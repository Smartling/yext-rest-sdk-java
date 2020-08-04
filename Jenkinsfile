#!groovy
pipeline {
    agent none

    options {
        buildDiscarder(logRotator(artifactNumToKeepStr: '5', numToKeepStr: '5'))
    }

    stages {
        stage('Build and test') {
            agent {
                label 'master'
            }
            steps {
                sh "sudo chmod +x gradlew"
                sh "./gradlew clean test"
                stash 'all'
            }
            post {
                always {
                    junit "**/test-results/test/*.xml"
                }
            }
        }

        stage('Run Integration tests') {
            agent {
                label 'master'
            }
            steps {
                sh "sudo chmod +x gradlew"
                withCredentials([usernamePassword(credentialsId: 'yext-sdk', passwordVariable: 'accessToken', usernameVariable: 'userId'), usernamePassword(credentialsId: 'Artifactory file', passwordVariable: 'ci_pass', usernameVariable: 'continuous_integration')]) {
                    sh "./gradlew integrationTest -Dyext.accessToken=${accessToken}"
                    stash 'all'
                }
            }
            post {
                always {
                    junit "**/test-results/integrationTest/*.xml"
                }
            }
        }

        stage('Upload artifacts') {
            agent {
                label 'master'
            }
            steps {
                unstash 'all'

                sh "sudo chmod +x gradlew"
                withCredentials([
                        usernamePassword(credentialsId: 'Artifactory file', passwordVariable: 'ci_pass', usernameVariable: 'continuous_integration'),
                        usernamePassword(credentialsId: 'artifactory-connectors-ci', passwordVariable: 'ci_pass_releases', usernameVariable: 'ci_user_releases')
                ]) {
                    sh "./gradlew uploadArchives"
                }
            }
        }
    }

    post {
        unstable {
            slackSend(
                    channel: "#emergency-connectors",
                    color: 'bad',
                    message: "Tests failed: <${env.RUN_DISPLAY_URL}|${env.JOB_NAME} #${env.BUILD_NUMBER}>"
            )
        }

        failure {
            slackSend(
                    channel: "#emergency-connectors",
                    color: 'bad',
                    message: "Build of <${env.RUN_DISPLAY_URL}|${env.JOB_NAME} #${env.BUILD_NUMBER}> is failed!"
            )
        }
    }
}
