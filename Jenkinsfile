pipeline {
    agent any
    environment {
        version = '1.0'
    }
    stages {
        stage('Git Checkout') {
            steps {
                script {
                    git branch: 'master', url: 'https://github.com/NicolasMb-eng/devopsmodule.git'
                }
            }
        }

        stage('Build') {
            steps {
                sh 'ls -ltr'
                sh 'mvn clean package'
            }
        }


       
    }
}