pipeline {
    agent any

    environment {
        REMOTE_HOST = 'ip'          
        REMOTE_USER = 'ubuntu'                
        APP_NAME = 'java'
        DOCKER_IMAGE = 'java1'
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

                            echo "🔮Stopping and removing old container (if exists)..."
                            sudo docker stop $APP_NAME || true
                            sudo docker rm $APP_NAME || true
                
                            echo "🔮Building Docker image $DOCKER_IMAGE..."
                            sudo docker build . -t $DOCKER_IMAGE
                            sudo docker images
                        
                            echo "🔮Running new container..."
                            sudo docker run -d --name $APP_NAME -p 80:80 $DOCKER_IMAGE
                            sudo docker ps
                            date

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
