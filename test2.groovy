node{
        timestamps {
            stage('one') {
                sh "echo hello; exit 1"
            }
            stage('two') {
                sh "echo world"
            }

        }
       // failFast: true
}
