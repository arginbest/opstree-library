def call() {
def p = pipelineConfig()
pipeline {
  agent any
    stages {
      stage('buld') { 
        steps {
            sh "echo hello"      
            }
      }
    stage('test') { 
        steps {
            sh "echo hello2"      
            }
      }
    stage('deploy') { 
        steps {
            sh "echo hello3"      
            }
      }
    stage('deploy2') { 
        steps {
            sh "echo hello4"      
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