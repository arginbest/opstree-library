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
            emailext body: 'need attention', subject: 'jenkins job', to: 'baurzhansiit@gmail.com'
        }
    }
    },
    failFast: true
}


// mail bcc: '', 
//             body: 'hello from jenkins', 
//             cc: '', 
//             from: '', 
//             replyTo: '', 
//             subject: 'jenkins-test', 
//             to: 'baurzhansiit@gmail.com'
