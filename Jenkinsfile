pipeline {

    environment {

     springF="achat_back"   
     angularF="achat_front"   
     DOCKERHUB_CREDENTIALS=credentials('dockerhub_id') 
   }

          agent any

          stages{

            stage('Get project from GIT'){
                steps{
                    echo 'Pulling...';
                    git branch: 'Sarra',
                    url : 'https://github.com/OumaimaBenzarti/ProjetDevops-.git';
                }
            }
            stage('Cleaning..') {

                steps {
                sh ' cd ${springF} && mvn clean install -DskipTests'
            }
        }
            stage('Compiling..') {
                steps {
                sh 'cd ${springF} && mvn compile'
            }
        }
            stage('Testing..') {
                steps {
                sh 'echo "test"'
            }
        }
            stage('MVN SONARQUBE')
            {
                steps{
                sh 'cd ${springF} && mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=admin123'
                }
            }



            stage("Nexus deploy"){
                steps{
                     script{
                        nexusArtifactUploader artifacts: [[artifactId: 'achat', classifier: '', file: 'achat_back/target/achat-1.0.jar', type: 'jar']], credentialsId: 'nexus_cre', groupId: 'tn.esprit.rh', nexusUrl: '192.168.33.10:8081', nexusVersion: 'nexus3', protocol: 'http', repository: 'Devops', version: '1.0'
                     }
                    }

                }


    stage("build and push back/front images"){
        steps{
            script {
            
            echo "====++++executing build and push back + front images++++===="
    
            withCredentials([usernamePassword(credentialsId: 'dockerhub_id', passwordVariable: 'pass', usernameVariable: 'user')]) {
                            sh "docker build -t $user/achat_back ${springF}/"
                            //sh "docker build -t $USER/achat_front ${angularF}/"
                            sh "echo $pass | docker login -u $user --password-stdin"
                            sh "docker push $user/achat_back"
}
        }
        }
        post{
        
            success{
                echo "====++++push image execution failed++++===="
            }
        
            failure{
                echo "====++++push image execution failed++++===="
            }
    
        }
    }
    stage('Deploy App'){
        steps {
            sh 'docker-compose up --build -d'
        }

        post{
        
            success{
                echo "====++++Success++++===="
            }
        
            failure{
                echo "====++++Failed++++===="
            }
    
        }
                    

          }
}
}