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

        stage('Checkout') {

            steps {

                echo 'Cloning Repository'

                git 'https://github.com/Zain6227/selenium-framework.git'
            }
        }

        stage('Build & Test') {

            steps {

                echo "Environment : ${params.ENV}"
                echo "Browser : ${params.BROWSER}"

                bat """
                C:\\Users\\zain.ul.abedin\\Downloads\\apache-maven-3.9.16-bin\\apache-maven-3.9.16\\bin\\mvn.cmd clean test -Denv=${params.ENV} -Dbrowser=${params.BROWSER}
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