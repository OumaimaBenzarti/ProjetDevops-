pipeline {
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
                sh 'mvn clean'
            }
        }
            stage('Compiling..') {
                steps {
                sh 'mvn compile'
            }
        }
            stage('Testing..') {
                steps {
                sh 'mvn test'
            }
        }
            stage('MVN SONARQUBE')
            {
                steps{
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=admin123'
                }
            }
             stage("Nexus deploy"){
                 steps{
                    sh 'mvn deploy'
                    }
                    }

          }
}