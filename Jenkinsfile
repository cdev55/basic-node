pipeline {
  agent any
  environment {
    BRANCH_NAME = "${env.BRANCH_NAME}"
    SERVER_CREDS = credentials('demo-creds')
  }

  parameters {
    string(name: 'BRANCH_NAME', defaultValue: 'main', description: 'The branch to build')
    choice(name: 'VERSION', choices: ['1.0.0', '1.0.1'], description: 'The version to build')
    booleanParam(name: 'execute_test', defaultValue: true, description: 'Enable debug mode')
  }

  stages {
    stage("build"){
        when {
            expression {
                BRANCH_NAME == "main" || BRANCH_NAME == "dev"
            }
        }
      steps {
        echo "Building the application..."
      }
    }
    stage("test"){
        when {
            expression {
                params.execute_test==true
            }
        }
      steps {
        echo "Testing the application..."
      }
    }
    stage("deploy") {
      steps {
        echo "Deploying the application..."
        withCredentials([
            usernamePassword(credentialsId: 'demo-creds', usernameVariable: 'USER', passwordVariable: 'PWD')
        ]) {
            sh 'echo $USER'
            sh 'echo $PWD'
            sh 'echo $SERVER_CREDS'
            sh 'echo deploy version: ${params.VERSION}'
        }
      }
    }
  }
}