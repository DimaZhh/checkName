pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh '''
                echo "Start Tests"
                mvn clean test
                '''
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}