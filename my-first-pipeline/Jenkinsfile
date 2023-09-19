pipeline {
  agent {
    docker { image 'node:15-alpine' }
  }
  stages {
    stage('Test') {
      steps {
        sh 'node --version'
      }
    }
  }
}
