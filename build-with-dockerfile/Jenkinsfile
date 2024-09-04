pipeline {
  agent { dockerfile true }
  stages {
    stage('Test') {
      steps {
        sh '''
          node --version
          git --version
          curl --version
        '''
      }
    }
  }
}