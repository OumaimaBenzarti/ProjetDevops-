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
                    sh 'cd ${springF} && mvn deploy'
                    }

                    }

          }
}