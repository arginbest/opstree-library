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
          step([$class: 'Mailer',
            notifyEveryUnstableBuild: true,
            recipients: "example@example.com",
            sendToIndividuals: true])
        }
    }
}