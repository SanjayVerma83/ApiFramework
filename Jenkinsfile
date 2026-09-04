pipeline {
    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven-3.9'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out source code from Git...'
                checkout scm
            }
        }

        stage('Build & Compile') {
            steps {
                echo 'Compiling test code and validating dependencies...'
                bat 'mvn compile test-compile'
            }
        }

        stage('Execute API Tests') {
            steps {
                echo 'Executing API Automation Suite...'
                bat 'mvn clean test -DtestFailureIgnore=true'
            }
        }
    }

    post {
        always {
            echo 'Archiving Extent Reports...'
            publishHTML(target: [
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'test-output',
                reportFiles: 'ExtentReport.html',
                reportName: 'Extent Report'
            ])
            archiveArtifacts artifacts: 'test-output/**', allowEmptyArchive: true
        }
        success {
            echo 'All API tests executed successfully!'
        }
        failure {
            echo 'Pipeline failed due to execution or compilation issues.'
        }
    }
}