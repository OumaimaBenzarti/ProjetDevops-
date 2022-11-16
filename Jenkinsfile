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
            // stage("Nexus deploy"){
              //   steps{
                //    sh 'mvn deploy'
                   // nexusArtifactUploader artifacts: [[artifactId: 'achat', classifier: '', file: '/var/lib/jenkins/workspace/Spring_IOC/target/achat-1.0.jar', type: 'jar']], credentialsId: 'nexus3', groupId: 'tn.esprit.rh', nexusUrl: '192.168.33.10:8081', nexusVersion: 'nexus3', protocol: 'http', repository: 'nexus-snapshots', version: '2.2.4'

                    }
                    }

          }
}