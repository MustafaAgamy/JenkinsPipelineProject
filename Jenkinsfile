pipeline {
    agent any

    environment {
        PROJECT_ROOT = 'D:\\Testing\\Automation\\JenkinsPipeline\\JenkinsPipelineProject'
        WORKSPACE_WINDOWS = 'C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\FirstPipeLine'
        WORKSPACE = 'C:/ProgramData/Jenkins/.jenkins/workspace/FirstPipeLine'
        TARGET_FOLDER = 'target'
        SUREFIRE_REPORTS = '/surefire-reports'
        HTML_REPORT = '/emailable-report.html'
        EMAIL_RECIPIENT = 'czczc2009@gmail.com'

    }

    stages {
        stage('Cleanup') {
            steps {
                script {
                   def targetPath = "${WORKSPACE_WINDOWS}\\${TARGET_FOLDER}"
                   if (fileExists(targetPath)) {
                    // Delete the target folder
                    bat "rmdir /s /q ${targetPath}"
                    bat "echo Target directory removed successfully : ${targetPath}"
                    } else {
                        echo "Target directory does not exist at : ${targetPath}. No cleanup needed."
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
                  def attachmentPath = "${TARGET_FOLDER}${SUREFIRE_REPORTS}${HTML_REPORT}"
                    if(fileExists(attachmentPath)){
                         bat "echo File exists at: ${attachmentPath}"
                    } else {
                         bat "echo File doesn't exist at: ${attachmentPath}"
                    }
                    // Attach the HTML file and send email
                    emailext (
                        subject: "Test Results",
//                         body: "Please find the attached test results.",
                        //To be used if you want the report to be viewed in the body of the mail
                        body: "Please find the attached test results."
                         readFile("${WORKSPACE}${HTML_FILE}"),
                        to: "${EMAIL_RECIPIENT}",
//                         replyTo: "noreply@example.com",
                        mimeType: 'text/html',

                        //To be used if you want the report to attached to the mail
                        attachmentsPattern: "${attachmentPath}"
                    )
                }
            }
        }
    }
}
