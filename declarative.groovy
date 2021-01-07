pipeline {
  agent any
    stages {
      stage('buld') { 
        steps {
            sh "echo hello"      
            }
        steps {
            sh "echo hello"      
            }
        steps('tree') {
            sh "echo hello"      
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
        }
    }
}
