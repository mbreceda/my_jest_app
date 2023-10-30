def COVERAGE_REPORT_LOCATIONS = ['artifacts/coverage/cobertura-coverage.xml']
def JUNIT_REPORT_LOCATIONS = ['artifacts/junit/junit.xml']

pipeline {
    agent any

    stages {
        stage('Download Projects') {
            steps {
                checkout scmGit(
                    branches: [[name: 'dev']],
                    userRemoteConfigs: [[url: 'https://github.com/mbreceda/my_jest_app.git']])
            }
        }
        stage('Build project') {
            steps {
                nodejs(nodeJSInstallationName: 'Node 20.x') {
                    sh 'npm install'
                    sh 'npm run test:ci'
                    sh 'ls'
                }
            }
        }
    }
    post {
        always {
            script {
                // cobertura autoUpdateHealth: false, 
                // autoUpdateStability: false, 
                // coberturaReportFile: '**/cobertura-coverage.xml', 
                // conditionalCoverageTargets: '80, 0, 0', 
                // failUnhealthy: false, 
                // failUnstable: false, 
                // lineCoverageTargets: '80, 0, 0',
                // maxNumberOfBuilds: 0, 
                // methodCoverageTargets: '80, 0, 0', 
                // sourceEncoding: 'ASCII', 
                // zoomCoverageChart: false
                
                // COVERAGE_REPORT_LOCATIONS.each { location ->
                //     cobertura autoUpdateHealth: false, 
                //     autoUpdateStability: false, 
                //     coberturaReportFile: '**/cobertura-coverage.xml', 
                //     conditionalCoverageTargets: '80, 0, 0', 
                //     failUnhealthy: false, 
                //     failUnstable: false, 
                //     lineCoverageTargets: '80, 0, 0',
                //     maxNumberOfBuilds: 0, 
                //     methodCoverageTargets: '80, 0, 0', 
                //     sourceEncoding: 'ASCII', 
                //     zoomCoverageChart: false
                // }
                
                publishCoverage adapters: [
                    cobertura(mergeToOneReport: true, path: 'artifacts/coverage/cobertura-coverage.xml')    
                ]
            }
        }
    }
}
