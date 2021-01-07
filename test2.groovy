node {
    try {
        stage('one') {
            sh "echo Hello; exit 1"
        }
        stage('two') {
            sh "echo world"
        }
         stage('tree') {
            sh "echo world"
        }
         stage('four') {
            sh "echo world"
        }

    } catch (err) {
        echo "Caught: ${err}"
        currentBuild.result = 'FAILURE'
    }
    step([$class: 'Mailer', recipients: 'baurzhansiit@gmail.com'])
}