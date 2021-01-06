node{
        timestamps {
            stage('one') {
                sh "echo hello; exit 1"
            }
            stage('two') {
                sh "echo world; exit 1"
            }

        }
       // failFast: true
}
