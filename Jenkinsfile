
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
                    sh 'ls -l ./target/'
                }
            }
        }
        stage(' Build Docker Image ') {
            steps {
                script {
                    echo 'building the docker image...'
                    sh 'docker build -t maven-app .'
                    
                }
            }
        }
        stage(' Push Docker Image to Docker Hub ') {
            steps {
                script {
                    echo 'pushing the image to docker hub...'
                    withCredentials([usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'PASS', usernameVariable: 'USER')]){
                        sh "echo $PASS | docker login -u $USER --password-stdin "
                        sh "docker tag maven-app $USER/maven-app"
                        sh "docker push $USER/maven-app"
                    }
                    
                }
            }
        }
        stage(' Deploy the application on a container ') {
            steps {
                script {
                    echo ' deploying the application ....'
                    withCredentials([usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'PASS', usernameVariable: 'USER')]){
                        sh " docker run $USER/maven-app "                        
                    }
                }
            }
        }
    }   
}
