pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test -DsuiteXmlFile=config/TestSuites/testng.xml -Denv=uat'
            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: '**/reports/*.xml', allowEmptyArchive: true
            junit '**/reports/*.xml'
        }
        failure {
            echo 'Tests failed.'
        }
        success {
            echo 'Tests passed successfully.'
        }
    }
}
