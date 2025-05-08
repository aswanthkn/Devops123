pipeline {
    agent any

    environment {
        IMAGE_NAME = "myapp-image"
        CONTAINER_NAME = "myapp-container"
    }

    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'master', url: 'https://github.com/aswanthkn/Devops123.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    echo "Building Docker image..."
                    sh "docker build -t $IMAGE_NAME ."
                }
            }
        }

        stage('Clean Dangling Images') {
            steps {
                script {
                    echo "Removing dangling images..."
                    sh "docker image prune -f"
                }
            }
        }

        stage('Run Docker Container') {
            steps {
                script {
                    echo "Stopping and removing any existing container..."
                    sh "docker rm -f $CONTAINER_NAME || true"

                    echo "Running new container..."
                    sh "docker run -d --name $CONTAINER_NAME $IMAGE_NAME"
                }
            }
        }
    }

    post {
        success {
            echo "Pipeline completed successfully."
        }
        failure {
            echo "Pipeline failed."
        }
    }
}
