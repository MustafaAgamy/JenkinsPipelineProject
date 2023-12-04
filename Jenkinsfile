pipeline {
    agent any

    environment {
        PROJECT_ROOT = 'D:\\Testing\\Automation\\JenkinsPipeline\\JenkinsPipelineProject'
        WORKSPACE = 'C:/ProgramData/Jenkins/.jenkins/workspace/FirstPipeLine'
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
               def attachmentPath = "${WORKSPACE}\\target\\surefire-reports\\emailable-report.html"
                    if(fileExists(attachmentPath)){
                         bat "echo File exists: ${attachmentPath}"
                    } else {
                         bat "echo File doesn't exist at: ${attachmentPath}"
                    }


                    // Attach the HTML file and send email
                    emailext (
                        subject: "Test Results",
                        body: "Please find the attached test results.",
//                         body: readFile("${WORKSPACE}${HTML_FILE}"),
//                         recipientProviders: [[$class: 'DevelopersRecipientProvider']],
                        to: "${EMAIL_RECIPIENT}",
//                         replyTo: "noreply@example.com",
                        mimeType: 'text/html',
//                          attachments: [
//                         [file: attachmentPath, fileName: 'emailable-report.html']]
                        attachmentsPattern: "${attachmentPath}"
                    )
                }
            }
        }
    }
}
