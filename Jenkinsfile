pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    options {
        timestamps()
        buildDiscarder(logRotator(numToKeepStr: '15'))
    }

    stages {

        stage('Checkout') {
            steps {
                echo "Obteniendo el codigo fuente desde el repositorio Git"
                checkout scm
                sh 'git log -1 --oneline'
            }
        }

        stage('Build') {
            steps {
                echo "Compilando el proyecto y ejecutando las pruebas unitarias"
                sh 'mvn -B clean verify'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Analisis SonarQube') {
            steps {
                echo "Ejecutando el analisis estatico de codigo"
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn -B sonar:sonar'
                }
            }
        }

        stage('Quality Gate') {
            steps {
                echo "Validando el Quality Gate como criterio de aceptacion"
                timeout(time: 5, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline completado: el codigo cumple el Quality Gate definido.'
        }
        failure {
            echo 'Pipeline fallido: revisar las pruebas unitarias o el Quality Gate.'
        }
    }
}
