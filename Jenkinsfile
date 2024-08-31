pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Construindo o projeto...'
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Executando o Teste Cucumber...'
                sh 'mvn test'
            }
            post {
                always {
                    echo 'Gerando relatório Cucumber...'
                    cucumber fileIncludePattern: '**/target/cucumber/*.json',
                             sortingMethod: 'ALPHABETICAL'
                }
            }
        }

        stage('Report') {
            steps {
                echo 'Arquivando Relatório...'
                archiveArtifacts artifacts: '**/target/cucumber/*', allowEmptyArchive: true
            }
        }
    }

    post {
        always {
            echo 'Cleaning up workspace...'
            cleanWs()
        }
        success {
            echo 'Build successful!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
