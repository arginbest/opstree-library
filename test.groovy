node{
    try {
        parallel a: {
            timestamps {
            stage('one') {
                sh "echo hello"
            }
        }
        }, b: {
            timestamps {
            stage('two') {
                sh "echo world: exit 1"
                sh "exit 1"
            }
            stage('mail notification') {
                emailext body: 'need attention', subject: 'jenkins job', to: 'baurzhansiit@gmail.com'
            }
        }
        },
        failFast: true
    } catch (err) {
        mail bcc: '', body: "hello from jenkins you have ${err}", cc: '', from: '', replyTo: '', subject: 'jenkins-test', 
            to: 'baurzhansiit@gmail.com'
        // emailext body: "${err}", subject: 'fail', to: 'baurzhansiit@gmail.com'
    }
}



