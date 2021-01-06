node{
    try {
        parallel a: {
            timestamps {
            stage('one') {
                sh "echo hello"
                sh "exit 1"
            }
        }
            , b: {
                    timestamps {
                    stage('two') {
                        sh "echo world"
                    }
                    stage('mail notification') {
                        emailext body: 'need attention', subject: 'jenkins job', to: 'baurzhansiit@gmail.com'
                        }
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
}



