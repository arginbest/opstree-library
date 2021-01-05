def call() {
  Map pipelineConfig = readYaml(file: "${WORKSPACE}/Pipeline.yaml")
  return pipelineConfig
}
