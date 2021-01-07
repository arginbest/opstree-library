package com.example

class Pipeline {
    def script
    def configurationFile

    Pipeline(script, configurationFile) {
        this.script = script
        this.configurationFile = configurationFile
    }
    
    def execute() {
//    ===================== Your Code Starts Here =====================
//    Note : use "script" to access objects from jenkins pipeline run (WorkflowScript passed from Jenkinsfile)
//           for example: script.node(), script.stage() etc
 
       script.node() {

           script.stage("Pull SCM") {
            //    script.git 'https://github.com/arginbest/challange.git'
            }

            script.stage('Read YAML file') {
                script.echo "${script.pwd}"
                script.def file = readYaml file: "${this.configurationFile}" 
                }
                script.stage('cleanUp') {
                    script.cleanWs()
                }
        
        }

   
   
   
// pipeline {
//   agent any
//     stages {
//       stage('whatever') {
//         steps {
//           sh "echo Hello"
//         }
//       }
//     }
//     post {
//         always {
//             sh "echo Hello"
//         }
//       }
//     }
//    ===================== Parse configuration file ==================

//    ===================== Run pipeline stages =======================

//    ===================== End pipeline ==============================
    }
}