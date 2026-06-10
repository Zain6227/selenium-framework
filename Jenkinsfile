pipeline {
    agent any

    parameters {
        choice(name: 'ENV', choices: ['qa', 'uat', 'prod'], description: 'Select Environment')
        choice(name: 'BROWSER', choices: ['chrome', 'edge', 'firefox'], description: 'Select Browser')
    }

    stages {
        stage('Build & Test') {
            steps {
                bat """
                "C:\\Users\\zain.ul.abedin\\Downloads\\apache-maven-3.9.16-bin\\apache-maven-3.9.16\\bin\\mvn.cmd" clean test -Denv=${params.ENV} -Dbrowser=${params.BROWSER}
                """
            }
        }
    }

    post {
        always {
            publishHTML(target: [
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'reports', 
                reportFiles: 'ExtentReport.html', 
                reportName: 'Extent Report'
            ])
        }
    }
}