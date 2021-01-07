pipeline {

    agent any

    stages {

        stage('Build testJob') {

            steps {
                script {
                    
                    echo "Build of 'testJob' returned result:"

                    
                }
            steps {
                echo "second step"
            }
            }
        }
    }

    post {

        always {
            echo "Build results"
        }

        success {
            echo "All builds completed OK"
        }

        failure {
            echo "A job failed"

            script {
                mail bcc: '', 
                body: "Check console output at '${env.BUILD_URL}' error output = ${err}", 
                cc: '', from: '', replyTo: '', subject: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'", 
                    to: 'baurzhansiit@gmail.com'
            }
        }
    }
}
