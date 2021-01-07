def call() {
pipeline {
  agent any
    stages {
        stage('Buld') { 
            steps {
                script{
                    def p = pipelineConfig()
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
        
        stage('test') { 
            steps {
                script{
                    def p = pipelineConfig()
                    env.FILENAME = "${p}"
                    echo "${p}"
                    parallel( "${p.test.name[0]}": {
                                           timestamps {
                                                dir("${p.test.testFolder[0]}") {
                                                sh "${p.test.testCommand[0]}"
                                               }
                                           } 
                                        },
                            "${p.test.name[1]}": {
                                    timestamps {
                                        dir("${p.test.testFolder[1]}") {
                                        sh "${p.test.testCommand[1]}"
                                        }      
                                    }
                                }, 
                                "${p.test.name[2]}": { 
                                    timestamps {
                                        dir("${p.test.testFolder[2]}") {
                                        sh "${p.test.testCommand[2]}"
                                        }
                                    }
                                }
                             )
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
        failure {
            echo 'I failed :('
            mail bcc: '', 
            body: "Please go to ${env.BUILD_URL}/consoleText for more details. ", 
            cc: '', from: '', replyTo: '', subject: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'", 
            to: "${p.notifications.email.recipients}"
        }
        changed {
            echo 'Things were different before...'
            mail bcc: '', 
            body: "Please go to ${env.BUILD_URL}/consoleText for more details. ", 
            cc: '', from: '', replyTo: '', subject: "CHANGES MADE: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'", 
            to: "${p.notifications.email.recipients}"
        }
    }
}
}