def call() {
  Map pipelineConfig = readYaml(file: "${WORKSPACE}/Pipeline.yml")
  return pipelineConfig
}
