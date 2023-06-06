pipeline {
    agent any
    tools { 
        maven 'MAVEN_3_9_1'
        jdk 'JDK_1_17'
    }
	
    stages {
        stage ('Compile Stage') {

            steps {
                withMaven(maven : 'MAVEN_3_9_1') {
                    sh 'mvn clean compile'
                }
            }
        }

        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'MAVEN_3_9_1') {
                    sh 'mvn test'
                }
            }
        }

        stage ('sonarQube Analysis') {

        	steps {
        		withMaven(maven : 'MAVEN_3_9_1') {
       				sh 'mvn clean verify sonar:sonar \
                          -Dsonar.projectKey=psychohelp \
                          -Dsonar.host.url=http://20.55.113.23:9000 \
                          -Dsonar.login=sqp_e6855024f11c2f45fd4481b7988d26ba4242c9df'
       			}
       		}
        }

        stage ('Package Stage') {
            steps {
                withMaven(maven : 'MAVEN_3_9_1') {
                    sh 'mvn package'
                }
            }
        }


    }
}
