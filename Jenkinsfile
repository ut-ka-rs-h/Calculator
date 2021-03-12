pipeline {

    agent none

    stages {

        stage("Fix the permission issue") {

            agent any

            steps {
                sh "sudo chown root:jenkins /run/docker.sock"
            }

        }

        stage('Step 1') {

            agent {
                docker { image 'utkarsh233/my-pvt-repo:latest'}
            }
            stages {
                stage('Test') {
                    steps {
                        sh 'node --version'
                    }
                }
            }

        }

    }
}
