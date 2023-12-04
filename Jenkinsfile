pipeline {
    agent any

    environment {
        PROJECT_ROOT = 'D:\\Testing\\Automation\\JenkinsPipeline\\JenkinsPipelineProject'
        TARGET_FOLDER = 'target'
        SUREFIRE_REPORTS = 'surefire-reports/PipelineTest'
        HTML_FILE = 'Command line test.html'
        EMAIL_RECIPIENT = 'czczc2009@gmail.com'
    }

    stages {
        stage('Cleanup') {
            steps {
                script {
                    // Delete the target folder
                    bat "rmdir /s /q ${PROJECT_ROOT}/${TARGET_FOLDER}"
                }
            }
        }

        stage('Test') {
            steps {
                bat 'mvn clean test'
            }
        }

        stage('Send Email') {
            steps {
                script {
                    // Attach the HTML file and send email
                    emailext (
                        subject: "Test Results",
                        body: "Please find the attached test results.",
                        to: EMAIL_RECIPIENT,
                        attachLog: true,
                        attachmentsPattern: "${PROJECT_ROOT}\\${TARGET_FOLDER}\\${SUREFIRE_REPORTS}\\${HTML_FILE}"
                    )
                }
            }
        }
    }
}
