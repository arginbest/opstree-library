def call() {
    node() {

        stage('Checkout') {
            checkout scm
        }

       def p = pipelineConfig()

        stage('Prerequistes'){
                sh  "echo ${p.build.projectFolder}"
                
        }


        stage('Build & Test & login DockerHub') {
                withCredentials([usernamePassword(credentialsId: 'docker', passwordVariable: 'password', usernameVariable: 'username')]) {

    // some block

                sh "mvn --version"
                sh "docker login --username ${username} --password ${password}"
                
                // sh "mvn -Ddb_port=${p.DB_PORT} -Dredis_port=${p.REDIS_PORT} clean install"
        }
        }
        
        stage("clean dir") {
            cleanWs()
}

        stage ('Push Docker Image') {
                sh "docker build -t opstree/${p.SERVICE_NAME}:${BUILD_NUMBER} ."
              
                // sh "docker push opstree/${p.SERVICE_NAME}:${BUILD_NUMBER}"
        }

        stage ('Deploy') {
            echo "We are going to deploy ${p.SERVICE_NAME}"
            sh "kubectl set image deployment/${p.SERVICE_NAME} ${p.SERVICE_NAME}=opstree/${p.SERVICE_NAME}:${BUILD_NUMBER} "
            sh "kubectl rollout status deployment/${p.SERVICE_NAME} -n ${p.ENVIRONMENT_NAME} "
        }
    }
}
    
