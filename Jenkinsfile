
pipeline {
    agent any
    tools{
        maven 'Maven'
    }
    stages {
        stage(' Test App ') {
            steps {
                script {
                   echo " testing the application ...."
                    sh 'mvn test'
                }
            }
        }
        stage(' Build Jar ') {
            steps {
                script {
                    echo 'building the application ....'
                    sh 'mvn package'
                }
            }
        }
        stage(' Build Docker Image ') {
            steps {
                script {
                    echo 'building the docker image...'
                    sh 'docker build -t Maven-app .'
                    
                }
            }
        }
        stage(" Push Docker Image to Docker Hub ") {
            steps {
                script {
                    echo 'pushing the image to docker hub...'
                    withCredentials([script.usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'PASS', usernameVariable: 'USER')]){
                        sh "echo $PASS | docker login -u $USER --password-stdin "
                        sh "docker push Maven-app"
                    }
                    
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    echo " deploying the application ...."
                    sh "docker run Maven-app"
                }
            }
        }
    }   
}