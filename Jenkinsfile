def gv 

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

    stage("init"){
        steps {
            script {
                echo "Initializing the application..."
                gv=load 'script.groovy'
            }
        }
    }
    stage("build"){
        when {
            expression {
                BRANCH_NAME == "main" || BRANCH_NAME == "dev"
            }
        }
      steps {
        script {
            gv.build(params.VERSION)
        }
      }
    }
    stage("test"){
        when {
            expression {
                params.execute_test==true
            }
        }
      steps {
        script {
            gv.test()
        }
      }
    }
    stage("deploy") {
        input {
            message "Select the environment to deploy"
            ok "Done"
            parameters {
                choice(name: 'ENV', choices: ['dev', 'prod'], description: 'The environment to deploy')
            }
        }
      steps {
        script {
            echo "Deploying version: $params.VERSION to $params.ENV"
            gv.deploy(params.VERSION)
        }
        
      }
    }
  }
}