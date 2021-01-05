def call() {
  Map pipelineConfig = readYaml(file: "${WORKSPACE}/config.yml")
  return pipelineConfig
}
