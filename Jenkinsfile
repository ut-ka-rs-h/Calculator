pipeline {
    agent {
        sudo docker { image 'utkarsh233/my-pvt-repo:latest'}
    }
    stages {
        stage('Test') {
            steps {
                sh 'node --version'
            }
        }
    }
}
