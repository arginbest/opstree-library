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
