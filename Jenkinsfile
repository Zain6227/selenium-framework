pipeline {
    agent any

    parameters {
        choice(name: 'ENV', choices: ['qa', 'uat', 'prod'], description: 'Select Environment')
        choice(name: 'BROWSER', choices: ['chrome', 'edge', 'firefox'], description: 'Select Browser')
    }

    stages {
        stage('Build & Test') {
            steps {
                echo "Running tests on Environment: ${params.ENV}"
                echo "Running tests on Browser: ${params.BROWSER}"

                bat """
                "C:\\Users\\zain.ul.abedin\\Downloads\\apache-maven-3.9.16-bin\\apache-maven-3.9.16\\bin\\mvn.cmd" clean test -Denv=${params.ENV} -Dbrowser=${params.BROWSER}
                """
            }
        }
    }

    post {
        always {
            echo 'Pipeline Finished'
            
            // 1. Archive Screenshots (Adjust the path to where your framework saves screenshots)
            // This grabs any .png files in your target or test-output folders
            archiveArtifacts artifacts: '**/target/screenshots/**/*.png', allowEmptyArchive: true
            
            // 2. Publish Extent Report Link on the Jenkins Dashboard
            // Adjust 'reportDir' to point to the actual folder where Extent generates the HTML
            htmlPublisher(allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'target/ExtentReports', 
                reportFiles: 'index.html', 
                reportName: 'Extent Report',
                reportTitles: 'Automation Execution Report'
            )
        }
        success {
            echo 'Pipeline Passed'
        }
        failure {
            echo 'Pipeline Failed'
        }
    }
}