def call() {
  Map pipelineConfig = readYaml(file: "${WORKSPACE}/config.yaml")
  return pipelineConfig
}
