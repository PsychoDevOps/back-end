pipeline {
    agent any
    tools { 
        maven 'MAVEN_4_0_0'
        jdk 'JDK_1_8'
    }
	
    stages {
        stage ('Compile Stage') {

            steps {
                withMaven(maven : 'MAVEN_4_0_0') {
                    sh 'mvn clean compile'
                }
            }
        }

        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'MAVEN_4_0_0') {
                    sh 'mvn test'
                }
            }
        }

        stage ('package Stage') {
            steps {
                withMaven(maven : 'MAVEN_4_0_0') {
                    sh 'mvn package'
                }
            }
        }


    }
}
