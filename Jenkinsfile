pipeline {

    environment {

     springF="achat_back"   
     angularF="achat_front"    
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
            stage("preparation deploy"){
                steps{
                    
                    nodejs('Nodejs'){
                        sh 'cd ${angularF} && npm run build -- --outputPath=./dist/out'
                    }
 
                    }

                }

    stage("build and push back/front images"){
        steps{
            script {
            
            echo "====++++executing build and push back + front images++++===="
    
         withCredentials([usernamePassword(credentialsId: 'dockerhub_id', passwordVariable: 'PASS', usernameVariable: 'USER')]){
                            sh "docker build -t $USER/achat_back ${springF}/"
                            sh "docker build -t $USER/achat_front ${angularF}/"
                            sh "echo $PASS | docker login -u $USER --password-stdin"
                            sh "docker push $USER/achat_back"
                            sh "docker push $USER/achat_front"
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
                 stage("Docker Compose"){
                steps{
                    sh 'echo"test"'
                    }
            }

                    

          }
}