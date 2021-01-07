@Library ('opstree-library@main') _
mypipeline()

def call() {
  Map pipelineConfig = readYaml(file: "${WORKSPACE}/myconfig.yml")
  return pipelineConfig
}