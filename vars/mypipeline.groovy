Map pipelineConfig = readYaml(file: "${WORKSPACE}/myconfig.yml")
  return pipelineConfig
def call() {
    node() {

            stage('Checkout') {
                checkout scm
            }
        def p = pipelineConfig()
        
        dir("${p.build.projectFolder}") {
            stage('build'){
                sh "${p.build.buildCommand}"
                }
        }
        dir("${p.database.databaseFolder}") {
            stage('database') {
                sh "${p.database.databaseCommand}"
                }
        }
        dir("${p.build.projectFolder}") {
            stage("deploy"){
                sh "${p.deploy.deployCommand}"
                }
        }
        dir("${p.test.testFolder[0]}") {
            parallel a: {
                timestamps {
                stage("Run ${p.test.name[0]}") {
                    sh "${p.test.testCommand[0]}"
                }
            }
            }, b: {
                timestamps {
                stage("Run ${p.test.name[1]}") {
                    sh "${p.test.testCommand[1]}"
                }
            }
            }, c: {
                timestamps {
                stage("Run ${p.test.name[2]}") {
                    sh "${p.test.testCommand[2]}"
                }
            }
            }, failFast: true
        }

    
    }
}
