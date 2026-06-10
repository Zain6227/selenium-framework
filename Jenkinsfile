pipeline {
    agent any

    parameters {
        choice(
            name: 'ENV',
            choices: ['qa', 'uat', 'prod'],
            description: 'Select Environment'
        )

        choice(
            name: 'BROWSER',
            choices: ['chrome', 'edge', 'firefox'],
            description: 'Select Browser'
        )
    }

    stages {
        // The manual 'Checkout' stage has been removed. 
        // Jenkins automatically checks out the repository to the workspace before this point.

        stage('Build & Test') {
            steps {
                echo "Running tests on Environment: ${params.ENV}"
                echo "Running tests on Browser: ${params.BROWSER}"

                // Executing Maven test suite with dynamic parameters
                bat """
                "C:\\Users\\zain.ul.abedin\\Downloads\\apache-maven-3.9.16-bin\\apache-maven-3.9.16\\bin\\mvn.cmd" clean test -Denv=${params.ENV} -Dbrowser=${params.BROWSER}
                """
            }
        }
    }

    post {
        always {
            echo 'Pipeline Finished'
        }
        success {
            echo 'Pipeline Passed'
        }
        failure {
            echo 'Pipeline Failed'
        }
    }
}