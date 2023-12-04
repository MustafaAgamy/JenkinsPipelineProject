pipeline {
    agent any

    environment {
        PROJECT_ROOT = 'D:\\Testing\\Automation\\JenkinsPipeline\\JenkinsPipelineProject'
        WORKSPACE = 'C:/ProgramData/Jenkins/.jenkins/workspace'
        TARGET_FOLDER = 'target'
        SUREFIRE_REPORTS = 'surefire-reports/PipelineTest'
        HTML_FILE = '/FirstPipeLine/target/surefire-reports/emailable-report.html'
        EMAIL_RECIPIENT = 'czczc2009@gmail.com'

    }

    stages {
        stage('Cleanup') {
            steps {
                script {
                   def targetPath = "${PROJECT_ROOT}\\${TARGET_FOLDER}"
                   if (fileExists(targetPath)) {
                    // Delete the target folder
                    bat "rmdir /s /q ${targetPath}"
                    } else {
                        echo "Target directory does not exist. No cleanup needed."
                }
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
               def attachmentPath = 'C:/ProgramData/Jenkins/.jenkins/workspace/FirstPipeLine/target/surefire-reports/emailable-report.html'
                    // Attach the HTML file and send email
                    emailext (
                        subject: "Test Results",
                        body: "Please find the attached test results.",
//                         body: readFile("${WORKSPACE}${HTML_FILE}"),
//                         recipientProviders: [[$class: 'DevelopersRecipientProvider']],
                        to: "${EMAIL_RECIPIENT}",
//                         replyTo: "noreply@example.com",
                        mimeType: 'text/html',
                         attachments: [
                        [file: attachmentPath, fileName: 'emailable-report.html']]
//                         attachmentsPattern: "${WORKSPACE}${HTML_FILE}"
                    )
                }
            }
        }
    }
}
