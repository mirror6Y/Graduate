pipeline {
    agent {
        docker {
            image '3.8.6-openjdk-8' 
            args '-v /Users/mirror6/soft/m2:/root/.m2' 
        }
    }
    stages {
        stage('Build') { 
            steps {
                sh 'mvn -B -DskipTests clean package' 
            }
        }
    }
}
