pipeline {

    agent any

    stages {

        stage('Step 1') {

            agent {
                docker { image 'node:14-alpine'}
            }
            stages {
                stage('Test') {
                    steps {
                        echo 'hello, alpine version 14 is pulled'
                    }
                }
            }

        }

    }
}
