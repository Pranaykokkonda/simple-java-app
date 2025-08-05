pipeline {
    agent any

    environment {
        REMOTE_HOST = 'server-ip'          
        REMOTE_USER = 'ubuntu'                
        APP_NAME = 'java'
        DOCKER_IMAGE = 'Docker-yourname/image-name'
    }

    stages {
        stage('Checkout') {
            steps {
                sh 'rm -rf $WORKSPACE/*'
                git branch: 'main', url: 'https://github.com/Pranaykokkonda/simple-java-app.git'
                }
        }

        stage('Deploy to Remote Server') {
            steps {
                sshagent(['ssh-key']) {
                    sh """
                        zip -r testing.zip *
                        echo "🔮copying into remote server..."
                        scp -o StrictHostKeyChecking=no testing.zip $REMOTE_USER@$REMOTE_HOST:/home/ubuntu  
                        
                        ssh -o StrictHostKeyChecking=no $REMOTE_USER@$REMOTE_HOST << 'EOF'
                        
                            pwd
                            unzip testing.zip
                            ls -ltrh
                            echo "🔮Pulling Docker image $DOCKER_IMAGE..."
                            sudo docker pull $DOCKER_IMAGE
                            sudo docker images

                            echo "🔮Stopping and removing old container (if exists)..."
                            sudo docker stop $APP_NAME || true
                            sudo docker rm $APP_NAME || true
                        
                            echo "🔮Running new container..."
                            sudo docker run -d --name $APP_NAME -p 80:80 $DOCKER_IMAGE
                            sudo docker ps

                            echo "Deployment completed on remote server."
                    << EOF
                    """
                }
            }
        }
    }

    post {
        success {
            echo '✅Deployment successful'
        }
        
        failure {
            echo '❌Deployment failed.'
        }
    }
}
