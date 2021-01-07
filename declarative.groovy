pipeline {
  agent any
    stages {
      stage('buld') { 
        steps {
            sh "hello"      
            }
      }
    }
    post {
        always {
        mail bcc: '', 
        body: "Check console output at '${env.BUILD_URL}' error output = ${err}", 
        cc: '', from: '', replyTo: '', subject: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'", 
        to: 'baurzhansiit@gmail.com'
        }
    }
}