pipeline {
    agent any

    tools {
        nodejs 'my-nodejs'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Install') {
            steps {
                sh 'npm install'
            }
        }

        stage('Test') {
            steps {
                sh 'npm test'
            }
        }

        stage('Docker Build') {
            steps {
                echo 'Building Docker image...!!'
                sh 'docker build -t my-node-app .'
            }
        }

        stage('Docker Run') {
            steps {
                echo 'Running Docker container...!!'
                sh "docker rm -f my-node-app || true"
                sh 'docker run -d -p 3000:3000 --name my-node-app my-node-app'
            }
        }
    }
}