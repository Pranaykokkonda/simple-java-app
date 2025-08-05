pipeline {
    agent any

    environment {
        REMOTE_HOST = 'your.remote.server.ip'          // Replace with remote server IP
        REMOTE_USER = 'ubuntu'                          // SSH user
        REMOTE_APP_NAME = 'my-node-app'
        DOCKER_IMAGE = 'your-dockerhub-username/your-image-name:latest'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/your-username/your-repo.git'
            }
        }

        stage('Deploy to Remote Server') {
            steps {
                sshagent (credentials: ['remote-server-creds']) {
                    sh """
                        ssh -o StrictHostKeyChecking=no $REMOTE_USER@$REMOTE_HOST << EOF
                            echo "Pulling Docker image $DOCKER_IMAGE..."
                            docker pull $DOCKER_IMAGE

                            echo "Stopping and removing old container (if exists)..."
                            docker stop $REMOTE_APP_NAME || true
                            docker rm $REMOTE_APP_NAME || true

                            echo "Running new container..."
                            docker run -d --name $REMOTE_APP_NAME -p 3000:3000 $DOCKER_IMAGE

                            echo "Deployment completed on remote server."
                        EOF
                    """
                }
            }
        }
    }

    post {
        success {
            echo 'Deployment successful on remote server!'
        }
        failure {
            echo 'Deployment failed.'
        }
    }
}
