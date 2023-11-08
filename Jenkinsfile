pipeline {
    agent any
    environment {
        version = '1.0'
    }
    stages {
        stage('Git Checkout') {
            steps {
                script {
                    git branch: 'master', url: 'https://github.com/NicolasMb-eng/DevOpss.git'
                }
            }
        }

        stage('Build') {
            steps {
                sh 'ls -ltr'
                sh 'mvn clean package'
            }
        }
       
        
        stage('Unit Tests') {
            steps {
                    // Assurez-vous que vous êtes dans le répertoire du projet Maven
                    // Exécutez les tests unitaires avec Maven
                    echo "Test unitaire..."
                    sh 'mvn test'
            }
        }

        }

       
    }
}