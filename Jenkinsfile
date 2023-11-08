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

         stage('SonarQube') {
            steps {
                script {
                    try {
                        sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
                    } catch (Exception e) {
                        currentBuild.result = 'FAILURE'
                        error "Error running SonarQube analysis: ${e.message}"
                    }
                }
            }
        }

                stage('Mockito Tests') {
            steps {
                    // Assurez-vous que vous êtes dans le répertoire du projet Maven
                    // Exécutez les tests Mockito avec Maven (assurez-vous d'avoir configuré les tests Mockito correctement)
                    sh 'mvn clean test -Pmockito-tests'
                }

            post {
                always {
                    // Archive les rapports de test Mockito JUnit
                    junit 'target/surefire-reports/TEST-tn.esprit.rh.achat.FournisseurServiceStaticTest.xml'

                }
            }
        }
       
        
        stage('Unit Tests') {
            steps {
                    // Assurez-vous que vous êtes dans le répertoire du projet Maven
                    // Exécutez les tests unitaires avec Maven
                    sh 'mvn test -Ptest-with-database'
            }

            post {
                always {
                    // Archive les rapports de test unitaires JUnit
                    junit 'target/surefire-reports/TEST-*'


                }
            }
        }

        }




       
    }
}