node{
    parallel a: {
         timestamps {
        stage('one') {
            sh "echo hello"
        }
    }
    }, b: {
        timestamps {
        stage('two') {
            sh "echo world"
        }
        stage('mail notification') {
            mail bcc: '', 
            body: 'hello from jenkins', 
            cc: '', 
            from: '', 
            replyTo: '', 
            subject: 'jenkins-test', 
            to: 'baurzhansiit@gmail.com'
        }
    }
    },
    failFast: true
}

// emailext 
//     body: 'need attention', 
//     recipientProviders: [developers()], 
//     subject: 'jenkins job', 
//     to: 'baurzhansiit@gmail.com'