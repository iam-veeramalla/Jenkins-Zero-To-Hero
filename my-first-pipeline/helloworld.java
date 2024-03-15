pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                // Compile the Java code
                sh 'javac HelloWorld.java'
            }
        }
        stage('Test') {
            steps {
                // Run any tests if applicable
                // If there are tests for your Java code, you can run them here
            }
        }
        stage('Run') {
            steps {
                // Run the Java program
                sh 'java HelloWorld'
            }
        }
    }
}
