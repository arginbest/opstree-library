node {
  try {
    notifyStarted()
// sadasdsa
    notifySuccessful()
  } 
  
  catch (e) {
    currentBuild.result = "FAILED"
    notifyFailed()
    throw e
  }
}

def notifyStarted() { /* .. */ }

def notifySuccessful() { /* .. */ }

def notifyFailed() {

  emailext (
      
    )
}


        // stage('mail notification') {
        //     emailext body: 'need attention', subject: 'jenkins job', to: 'baurzhansiit@gmail.com'
        // }
        // currentBuild.result = "FAILED"
        // notifyFailed()

        // mail bcc: '', 
        // body: "Check console output at '${env.BUILD_URL}' error output = ${err}", 
        // cc: '', from: '', replyTo: '', subject: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'", 
        //     to: 'baurzhansiit@gmail.com'
        // emailext body: "${err}", subject: 'fail', to: 'baurzhansiit@gmail.com'


