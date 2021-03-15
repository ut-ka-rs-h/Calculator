pipeline {
    agent any
    stages {
	    stage('Build') { // build and tag docker image
		steps {
		    	script {  
				sh "docker build -t crepantherx.jfrog.io/techmahindra-docker-dev-local/notes:1.0.${env.BUILD_ID} ."
		    	}
		}
	    }

	    stage('Upload'){
		steps {
			script {  
				docker.withRegistry('https://crepantherx.jfrog.io', 'jfrog') {
					sh "docker push crepantherx.jfrog.io/techmahindra-docker-dev-local/notes:1.0.${env.BUILD_ID}"
				}
			}
		}
	    }
    }
}
