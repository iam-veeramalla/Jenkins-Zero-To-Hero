pipeline {
    agent {
        label 'my-agent-label'
        docker {
            image 'node:16-alpine'
        }
    }
    stages {
        stage('Test') {
            steps {
                sh 'node --version'
            }
        }
    }
}
