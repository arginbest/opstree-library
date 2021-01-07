def p = pipelineConfig()
def call() {
pipeline {
  agent any
    stages {
        stage('Buld') { 
            steps {
                script{
                    
                    dir("${p.build.projectFolder}") {
                        sh "${p.build.buildCommand}"
                    }
                }
            }
        }
        stage('Database') { 
            steps {
                script{
                    def p = pipelineConfig()
                    dir("${p.database.databaseFolder}") {
                        sh "${p.database.databaseCommand}"
                    }
                }      
            }
        }
        stage('Deploy') { 
            steps {
                script{
                    def p = pipelineConfig()
                    dir("${p.build.projectFolder}") {
                        sh "${p.deploy.deployCommand}"
                    }
                }
            }
        }

        stage('Test 1') { 
            steps {
                script{
                    def p = pipelineConfig()
                        dir("${p.test.testFolder[0]}") {
                            sh "${p.test.testCommand[0]}"
                        }
                    }      
                }
            }
        stage('Test 2') { 
            steps {
                script{
                    def p = pipelineConfig()
                        dir("${p.test.testFolder[1]}") {
                            sh "${p.test.testCommand[1]}"
                        }
                    }      
                }
            }
        stage('Test 3') { 
            steps {
                script{
                        dir("${p.test.testFolder[2]}") {
                            sh "${p.test.testCommand[2]}"
                        }
                    }      
                }
            }
        }
    post {
        always {
        echo 'One way or another, I have finished'
            deleteDir() /* clean up our workspace */
        }
        success {
            echo 'I succeeded!'
        }
        unstable {
            echo 'I am unstable :/'
        }
        failure {
            echo 'I failed :('
            mail bcc: '', 
            body: "Check console output at '${env.BUILD_URL}'", 
            cc: '', from: '', replyTo: '', subject: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'", 
            to: 'baurzhansiit@gmail.com'
        }

        changed {
            echo 'Things were different before...'
            mail bcc: '', 
            body: "Check changes at '${env.BUILD_URL}'", 
            cc: '', from: '', replyTo: '', subject: "changes: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'", 
            to: 'baurzhansiit@gmail.com'
        }
    }
}
}