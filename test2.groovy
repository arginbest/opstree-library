node{
        timestamps {
            stage('one') {
                sh "echo hello"
                sh "exit 1"
            }
            stage('two') {
                sh "echo world"
            }

        }
       // failFast: true
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


