node{
        timestamps {
            stage('one') {
                sh "echo hello"
            }
            stage('two') {
                sh "echo world"
            }

        }
       failFast: true
}