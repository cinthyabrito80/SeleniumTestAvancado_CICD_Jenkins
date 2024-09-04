pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Construindo o projeto...'
                bat 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                echo 'Executando os testes...'
                bat 'mvn test'
            }
        }
        stage('Report') {
            steps {
                echo 'Gerando relatório...'
                // Adicione o comando de relatório, por exemplo:
				archiveArtifacts artifacts: '**/target/cucumber/*', allowEmptyArchive: true
                bat 'mvn surefire-report:report'
            }
        }
    }
    post {
        always {
            echo 'Cleaning up workspace...'
            cleanWs()
        }
        failure {
            echo 'Build failed!'
        }
    }
}
