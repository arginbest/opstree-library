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
            script.stage('WorkflowScript') { 
                script.sh  "echo hello"
                script.commonPipelineEnvironment.configuration
                setupCommonPipelineEnvironment script: build
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