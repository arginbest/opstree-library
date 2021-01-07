def buildResults = [:]

void nofify_email(Map results) {
    echo "TEST SIMULATE notify: ${results.toString()}"
}

pipeline {

    agent any

    stages {

        stage('Build testJob') {

            steps {
                script {
                    def jobBuild = build job: 'testJob', propagate: false

                    def jobResult = jobBuild.getResult()

                    echo "Build of 'testJob' returned result: ${jobResult}"

                    buildResults['testJob'] = jobResult

                    if (jobResult != 'SUCCESS') {
                        error("testJob failed with result: ${jobResult}")
                    }
                }
            }
        }
    }

    post {

        always {
            echo "Build results: ${buildResults.toString()}"
        }

        success {
            echo "All builds completed OK"
        }

        failure {
            echo "A job failed"

            script {
                nofify_email(buildResults)
            }
        }
    }
}
