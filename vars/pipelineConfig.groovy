def call() {
  Map pipelineConfig = readYaml(file: "${WORKSPACE}/myconfig.yml")
  return pipelineConfig
}
