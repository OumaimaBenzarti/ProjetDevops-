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
                sh ' cd ${springF} && mvn clean'
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
                    nexusArtifactUploader artifacts: [[artifactId: 'achat', classifier: '', file: '/var/lib/jenkins/workspace/Devops/achat_back/target/achat-1.0.jar', type: 'jar']], credentialsId: 'nexus3', groupId: 'tn.esprit.rh', nexusUrl: '192.168.33.10:8081', nexusVersion: 'nexus3', protocol: 'http', repository: 'nexus-snapshots', version: '2.2.4'
                    
                    }

                }
                 stage("Docker Compose"){
                steps{
                    sh 'sudo -s docker-compose up -d'
                    }
            }

                    

          }
}