node{
        timestamps {
            stage('one') {
                sh "echo hello"
            }
            stage('two') {
                sh "echo world; exit 1"
            }

        }
       failFast: true
}