node {
    try {
        stage('one') {
            sh "echo Hello"
        }
        stage('two') {
            sh "echo world"
        }
         stage('tree') {
            sh "echo world; exit 1"
        }
         stage('four') {
            sh "echo world"
        }
        script {
            if (currentBuild.result != 'SUCCESS') {
                    echo 'Build has changed to SUCCESS status'
                }
        }

    } catch (err) {
        echo "Caught: ${err}"
        currentBuild.result = 'FAILURE'
    }
    step([$class: 'Mailer', recipients: 'baurzhansiit@gmail.com'])
}