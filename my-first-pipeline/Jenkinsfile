pipeline {
  agent {
    docker { image 'node:17-alpine' }
  }
  stages {
    stage('Test') {
      steps {
        sh 'node --version'
      }
    }
  }
}
