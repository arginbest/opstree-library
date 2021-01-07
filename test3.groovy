def call() {
pipeline {
  agent any
    stages {
      stage('buld') {
        def p = pipelineConfig()
          dir("${p.build.projectFolder}") {
        steps {
            sh "${p.build.buildCommand}"      
            }
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
}