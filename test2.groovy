node{
    try {
            stage('one') {
                sh "echo hello"
            }

            stage('two') {
                sh "echo world"
            }
        } failFast: true
     
    catch (err) {
        mail bcc: '', 
        body: "Check console output at '${env.BUILD_URL}' error output = ${err}", 
        cc: '', from: '', replyTo: '', subject: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'", 
            to: 'baurzhansiit@gmail.com'
    }
}