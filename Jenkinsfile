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
                    bat 'mvn clean compile'
                }
            }
        }

        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'MAVEN_3_9_1') {
                    bat 'mvn test'
                }
            }
        }

        stage ('package Stage') {
            steps {
                withMaven(maven : 'MAVEN_3_9_1') {
                    bat 'mvn package'
                }
            }
        }


    }
}
