def call() {
pipeline {
  agent any
    stages {
        stage('Buld') { 
            steps {
                script{
                    sh """
                    echo GIT_COMMIT %GIT_COMMIT% 
                    echo GIT_BRANCH %GIT_BRANCH%
                    echo GIT_LOCAL_BRANCH %GIT_LOCAL_BRANCH%
                    echo GIT_PREVIOUS_COMMIT %GIT_PREVIOUS_COMMIT%
                    echo GIT_PREVIOUS_SUCCESSFUL_COMMIT %GIT_PREVIOUS_SUCCESSFUL_COMMIT%
                    echo GIT_URL %GIT_URL%
                    echo GIT_URL_N - %GIT_URL_N%
                    echo GIT_AUTHOR_NAME %GIT_AUTHOR_NAME%
                    echo GIT_COMMITTER_EMAIL %GIT_COMMITTER_EMAIL%
                    """
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
                deleteDir()
            }
            success {
                mail bcc: '', 
                body: "Please go to ${env.BUILD_URL}/consoleText for more details. ", 
                cc: '', from: '', replyTo: '', subject: "CHANGES MADE: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'", 
                to: "my@box.com"
            }
            failure {
                echo 'I failed :('
                mail bcc: '', 
                body: """Please go to ${env.BUILD_URL}/consoleText for more details.,
                additional info: Name of the agent - ${env.NODE_NAME},
                The commit hash being checked out - ${env.GIT_COMMITTER_NAME}, ${env.GIT_COMMIT} """, 
                cc: '', from: '', replyTo: '', subject: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'", 
                to: "baurzhansiit@gmail.com"
            }
        }
    }
}