pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/rgunjal07/techniajz.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Docker Build') {
            steps {
                sh 'docker build -t rgunjal/techniajz .'
            }
        }
    }
}



