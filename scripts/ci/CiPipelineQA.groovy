node {
    def mvnHome
    def ORIGIN = "origin"
    def testEnabled = false
    def failOnTests = false
    def serviceName = repository[0..-5]
    def servicesMap = ['customer-login-service' :'customer-login-service-automation']
    def repositoryAutomation = servicesMap.get(serviceName) + '.git'
    ciPipelineQAJSON = readJSON text: '{}'
    def QaSignOff = "No"

    def repo
    def suiteFileIntegration
    def suiteFileWebTest
    def suiteFileAppTest
    def reportFileIntegration
    def reportFileWebTest
    def reportFileAppTest
    def suiteBackwardTest
    def reportBackwardTest
    def autoDeploy = false
    def suiteProdSanityTest


    def customWorkspace = repository[0..-5] + "/" + BUILD_NUMBER
    sh "mkdir -p " + customWorkspace


    dir("${customWorkspace}") {

        print "backwardCompatibilityTest : "
        print backwardCompatibilityTest
        if (backwardCompatibilityTest =='false') {

            configFileProvider(
                    [configFile(fileId: 'repo_file_config', variable: 'REPO_FILE_CONFIG')]) {
                echo "File : $REPO_FILE_CONFIG"

                def props = readJSON file: "$REPO_FILE_CONFIG"

                def repoConfig = props[repository]

                if (repoConfig != null) {

                    repo = repoConfig["repo"]
                    suiteFileIntegration = repoConfig["suiteIntegration"]
                    suiteFileWebTest = repoConfig["suiteWebTest"]
                    suiteFileAppTest = repoConfig["suiteAppTest"]
                    reportFileIntegration = repoConfig["reportIntegration"]
                    reportFileWebTest = repoConfig["reportWebTest"]
                    reportFileAppTest = repoConfig["reportAppTest"]
                    autoDeploy = repoConfig["autoDeploy"]
                    suiteProdSanityTest = repoConfig["suiteProdSanityTest"]

                }
            }
            if (repo!="") {

                if(prodSanity=="true"){

                    try {
                        stage('PreBuild') {
                            jdk = tool 'Java8'

                            println "++++++++ PreBuild ++++++++++++++"
                            println "The repo name :  ${repo}"

//                        if (servicesMap.containsKey(serviceName)) {

                            git "git@github.com:bankbazaar/${repo}.git"
                            mvnHome = tool 'Maven'
                            env.JAVA_HOME = jdk
                            env.PATH = "${env.JAVA_HOME}/bin:${env.PATH}"

                            logJavaVersion()
                            logMavenVersion()

//                        } else {
//
//                            throw new Exception("automation repository for ${serviceName} not found")
//                        }
                        }
                    }
                    catch (Exception e) {

                        def resultJsonProd = readJSON text: '{}'
                        resultJsonProd.status = "SKIP"

                        ciPipelineQAJSON.prodSanity = resultJsonProd

                        env.testJSON = ciPipelineQAJSON

                        println e

                        failOnTests = true

                        println env.testJSON

                        if (autoDeploy) {

                            println "this service QA signOff is fully automated, doesn't have manual qa signoff"
                            QaSignOff = 'Yes'

                        } else {
                            QaSignOff = manualQaSignOff()
                        }


                        return ciPipelineQAJSON
                    }

                    stage("prodSanityTest") {


                        if (suiteProdSanityTest == "NA" || suiteProdSanityTest == "") {

                            println "++++++++ No ProdSanityTest ++++++++++++++"

                            def resultJsonApp = readJSON text: '{}'
                            resultJsonApp.status = "NA"

                            ciPipelineQAJSON.prodSanity = resultJsonApp
                        } else {

                            println "++++++++ ProdSanityTest ++++++++++++++"
                            println "The repo name :  ${repo}"

                            ciPipelineQAJSON = executeProdSanityTest(suiteProdSanityTest, reportFileIntegration)

                            if (ciPipelineQAJSON.getAt("prodSanity").fails > 0) {

                                failOnTests = true

                                println "++++++++++++stage prodSanityTest ciPipelineQAJSON"
                                println ciPipelineQAJSON
                                return ciPipelineQAJSON

                            }
                            else {
                                if (autoDeploy) {

                                    println "this service QA signOff is fully automated, doesn't have manual qa signoff"
                                    QaSignOff = 'Yes'

                                } else {
                                    QaSignOff = manualQaSignOff()
                                }
                            }

                        }

                    }

                }
                else {
                    try {
                        stage('PreBuild') {
                            jdk = tool 'Java8'

                            println "++++++++ PreBuild ++++++++++++++"
                            println "The repo name :  ${repo}"

//                        if (servicesMap.containsKey(serviceName)) {

                            git "git@github.com:bankbazaar/${repo}.git"
                            mvnHome = tool 'Maven'
                            env.JAVA_HOME = jdk
                            env.PATH = "${env.JAVA_HOME}/bin:${env.PATH}"

                            logJavaVersion()
                            logMavenVersion()

//                        } else {
//
//                            throw new Exception("automation repository for ${serviceName} not found")
//                        }
                        }
                    }
                    catch (Exception e) {

                        def resultJsonWeb = readJSON text: '{}'
                        def resultJsonApp = readJSON text: '{}'
                        def resultJsonIntegration = readJSON text: '{}'
                        resultJsonWeb.status = "SKIP"
                        resultJsonApp.status = "SKIP"
                        resultJsonIntegration.status = "SKIP"

                        ciPipelineQAJSON.webTest = resultJsonWeb
                        ciPipelineQAJSON.appTest = resultJsonApp
                        ciPipelineQAJSON.integrationTest = resultJsonIntegration


                        env.testJSON = ciPipelineQAJSON

                        println e

                        failOnTests = true

                        println env.testJSON

                        if (autoDeploy) {

                            println "this service QA signOff is fully automated, doesn't have manual qa signoff"
                            QaSignOff = 'Yes'

                        } else {
                            QaSignOff = manualQaSignOff()
                        }


                        return ciPipelineQAJSON
                    }

                    stage("MavenBuild"){
                        sh "mvn -U clean compile install -DskipTests"

                    }

                    stage("IntegrationTest") {


                        if (suiteFileIntegration == "NA" || suiteFileIntegration == "") {

                            println "++++++++ No IntegrationTests ++++++++++++++"

                            def resultJsonApp = readJSON text: '{}'
                            resultJsonApp.status = "NA"

                            ciPipelineQAJSON.integrationTest = resultJsonApp
                        } else {

                            println "++++++++ IntegrationTest ++++++++++++++"
                            println "The repo name :  ${repo}"

                            ciPipelineQAJSON = executeIntegrationTest(suiteFileIntegration, reportFileIntegration)

                            if (ciPipelineQAJSON.getAt("integrationTest").fails > 0) {

                                def resultJsonWeb = readJSON text: '{}'
                                def resultJsonApp = readJSON text: '{}'
                                resultJsonWeb.status = "SKIP"
                                resultJsonApp.status = "SKIP"

                                ciPipelineQAJSON.webTest = resultJsonWeb
                                ciPipelineQAJSON.appTest = resultJsonApp

                                failOnTests = true

                                println "++++++++++++stage IntegrationTest ciPipelineQAJSON"
                                println ciPipelineQAJSON
                                return ciPipelineQAJSON

                            }
                        }

                    }

                    stage("FunctionalWebTest") {


                        if (failOnTests) {
                            return
                        }

                        if (suiteFileWebTest == "NA" || suiteFileWebTest == "") {

                            println "++++++++No FunctionalWebTests ++++++++++++++"

                            def resultJsonApp = readJSON text: '{}'
                            resultJsonApp.status = "NA"

                            ciPipelineQAJSON.webTest = resultJsonApp
                        } else {
                            println "++++++++++++++ FunctionalWebTest ++++++++++++++"
                            println "The repo name :  ${repo}"

                            ciPipelineQAJSON = executeFunctionalWebTest(suiteFileWebTest, reportFileWebTest)

                            if (ciPipelineQAJSON.getAt("webTest").fails > 0) {

                                def QaSignOffFunctional

                                QaSignOffFunctional = manualQaSignOff()

                                if (QaSignOffFunctional =='No'){
                                    def resultJsonApp = readJSON text: '{}'
                                    resultJsonApp.status = "SKIP"

                                    ciPipelineQAJSON.appTest = resultJsonApp
                                    failOnTests = true

                                    return ciPipelineQAJSON
                                }else {

                                    println "++++++++++++++ ManualSingOff given for functional failures ++++++++++++++"
                                }

                            }
                        }
                    }

                    stage("FunctionalAppTest") {

                        if (failOnTests) {
                            return
                        }
                        if (suiteFileAppTest == "NA" || suiteFileAppTest == "") {

                            println "++++++++No FunctionalAppTests ++++++++++++++"

                            def resultJsonApp = readJSON text: '{}'
                            resultJsonApp.status = "NA"

                            ciPipelineQAJSON.appTest = resultJsonApp
                        } else {

                            println "++++++++ FunctionalAppTest ++++++++++++++"
                            println "The repo name :  ${repo}"

                            ciPipelineQAJSON = executeFunctionalAppTest(suiteFileAppTest, reportFileAppTest)

                            if (ciPipelineQAJSON.getAt("appTest").fails > 0) {

                                return ciPipelineQAJSON

                            }
                        }

                    }

                    stage("manual QA step") {

                        println "++++++++ Manual QA sign off ++++++++++++++"

                        if (autoDeploy) {

                            println "this service QA signOff is fully automated, doesn't have manual qa signoff"
                            QaSignOff = 'Yes'

                        } else {
                            QaSignOff = manualQaSignOff()
                        }
                    }

                    stage('PostSignOff') {
                        //deleteDir()
                    }
                }
            }
            else {
                stage("manual QA step") {

                    println "++++++++repo is not present - Manual QA sign off ++++++++++++++"

                    QaSignOff = manualQaSignOff()
                }
            }
        }
        else if (backwardCompatibilityTest == 'true'){
            configFileProvider(
                    [configFile(fileId: 'repo_file_config', variable: 'REPO_FILE_CONFIG')]) {
                echo "File : $REPO_FILE_CONFIG"

                def props = readJSON file: "$REPO_FILE_CONFIG"

                def repoConfig = props[repository]

                if (repoConfig != null) {

                    repo = repoConfig["repo"]
                    suiteFileIntegration = repoConfig["suiteIntegration"]
                    suiteFileWebTest = repoConfig["suiteWebTest"]
                    suiteFileAppTest = repoConfig["suiteAppTest"]
                    suiteBackwardTest = repoConfig["suiteBackwardTest"]
                    reportFileIntegration = repoConfig["reportIntegration"]
                    reportFileWebTest = repoConfig["reportWebTest"]
                    reportBackwardTest = repoConfig["reportBackwardTest"]
                    reportFileAppTest = repoConfig["reportAppTest"]
                    autoDeploy = repoConfig["autoDeploy"]

                }
            }
            if (repo!="") {
                try {
                    stage('PreBuild') {
                        jdk = tool 'Java8'

                        println "++++++++ PreBuild ++++++++++++++"
                        println "The repo name :  ${repo}"

//                        if (servicesMap.containsKey(serviceName)) {
                        git "https://github.com/nishantautomationlabs/${repo}.git"
//                        git "git@github.com:nishantautomationlabs/${repo}.git"
                        mvnHome = tool 'Maven'
                        env.JAVA_HOME = jdk
                        env.PATH = "${env.JAVA_HOME}/bin:${env.PATH}"

                        logJavaVersion()
                        logMavenVersion()

//                        } else {
//
//                            throw new Exception("automation repository for ${serviceName} not found")
//                        }
                    }
                }
                catch (Exception e) {

                    def resultJsonWeb = readJSON text: '{}'
                    def resultJsonApp = readJSON text: '{}'
                    def resultJsonIntegration = readJSON text: '{}'
                    resultJsonWeb.status = "SKIP"
                    resultJsonApp.status = "SKIP"
                    resultJsonIntegration.status = "SKIP"

                    ciPipelineQAJSON.webTest = resultJsonWeb
                    ciPipelineQAJSON.appTest = resultJsonApp
                    ciPipelineQAJSON.integrationTest = resultJsonIntegration


                    env.testJSON = ciPipelineQAJSON

                    println e

                    failOnTests = true

                    println env.testJSON

                    if (autoDeploy){

                        println "this service QA signOff is fully automated, doesn't have manual qa signoff"
                        QaSignOff='Yes'

                    }
                    else
                    {
                        QaSignOff = manualQaSignOff()
                    }

                    return ciPipelineQAJSON
                }
                stage("MavenBuild"){
                    sh "mvn -U clean compile install -DskipTests"

                }
                stage("BackwardCompatibilityTest") {


                    if (suiteBackwardTest=="" || suiteBackwardTest=="NA"){

                        println "++++++++ No BackwardCompatibilityTests ++++++++++++++"

                        def resultJsonApp = readJSON text: '{}'
                        resultJsonApp.status = "NA"

                        ciPipelineQAJSON.backwardTest=resultJsonApp
                    }
                    else {

                        println "++++++++ BackwardCompatibilityTests ++++++++++++++"
                        println "The repo name :  ${repo}"

                        ciPipelineQAJSON = executeBackwardCompatibilityTest(suiteBackwardTest, reportBackwardTest)

                        if (ciPipelineQAJSON.getAt("backwardTest").fails > 0) {


                            failOnTests = true

                            println ciPipelineQAJSON
                            return ciPipelineQAJSON

                        }
                    }

                }

            }
            else {
                println "++++++++ backward compatibility test true : Repo not present : No tests ++++++++++++++"
            }

            QaSignOff='Yes';

        }
        else {
            stage("manual QA step") {

                println "++++++++ backwardCompatibilityTest neither true nor false - Manual QA sign off ++++++++++++++"

                QaSignOff = manualQaSignOff()
            }
        }
    }

    if(failOnTests || QaSignOff=='No'){

        if(repo=="" && QaSignOff=='Yes'){
            ciPipelineQAJSON.QaSignOff = true as boolean
        }
        else {
            ciPipelineQAJSON.QaSignOff = false as boolean
        }

    }
    else
    {
        ciPipelineQAJSON.QaSignOff = true as boolean
    }

    if (QaSignOff=='No'){

        ciPipelineQAJSON.manualQaSignOff = false as boolean

    }else{
        ciPipelineQAJSON.manualQaSignOff = true as boolean
    }
    env.testJSON = ciPipelineQAJSON

    println "complete final JSON ----> "
    println ciPipelineQAJSON

    return ciPipelineQAJSON

    }

private void  logJavaVersion(){
    println "using Java Version : "
    sh "java -version"
}

private void  logMavenVersion(){
    println "using Maven Version : "
    sh "mvn --version"
}

private executeIntegrationTest(suiteFileIntegration,reportFileIntegration){

        println "+++++ starting integration tests"
        try {

            sh "mvn clean -pl integration test -Denv=${environment} -Dlocale=IN -Dsurefire.suiteXmlFiles=src/test/resources/IN/suites/${suiteFileIntegration}"


            def resultJson = readJSON text: '{}'
            resultJson = extractSuiteResult("integration",suiteFileIntegration)

            if (resultJson.fails > 0) {
                resultJson.status = "FAIL"
            } else {
                resultJson.status = "PASS"
            }

            ciPipelineQAJSON.integrationTest = resultJson


        } catch (ex) {
            println "Error in test executeIntegrationTest"

            println ex

            def xmlFilePath = getPwd() + "/integration/target/suite_result.txt"
            def resultJson = readJSON text: '{}'
            def exists = fileExists xmlFilePath

            if (exists){
                println "suite_result file exists"
                resultJson = extractSuiteResult("integration",suiteFileIntegration)
            }
            else {
                resultJson.fails = 1 as int
                resultJson.status = "FAIL"
                resultJson.report = "Error in test executeIntegrationTest" as String
            }

            ciPipelineQAJSON.integrationTest = resultJson
            return ciPipelineQAJSON
        }
    return ciPipelineQAJSON
}

private executeFunctionalWebTest(suiteFileWebTest,reportFileWebTest){


        println "+++++ starting FunctionalWeb tests"
        try {

            sh "xvfb-run mvn clean -pl webapp test -Denv=${environment} -Dlocale=IN -Dsurefire.suiteXmlFiles=src/test/resources/IN/suites/${suiteFileWebTest}"

            def resultJson = readJSON text: '{}'
            resultJson = extractSuiteResult("webapp",suiteFileWebTest)

            if (resultJson.fails > 0) {
                resultJson.status = "FAIL"
            } else {
                resultJson.status = "PASS"
            }

            ciPipelineQAJSON.webTest = resultJson

        } catch (ex) {
            println "Error in test executeFunctionalWebTest"

            println ex

            def xmlFilePath = getPwd() + "/webapp/target/suite_result.txt"
            def exists = fileExists xmlFilePath

            def resultJson = readJSON text: '{}'

            if (exists){
                println "suite_result file exists"
                resultJson = extractSuiteResult("webapp",suiteFileWebTest)
            }
            else {
                resultJson.fails = 1 as int
                resultJson.status = "FAIL"
                resultJson.report = "Error in test executeFunctionalWebTest" as String
            }
            ciPipelineQAJSON.webTest = resultJson
            return ciPipelineQAJSON

        }
    return ciPipelineQAJSON

}

private executeBackwardCompatibilityTest(suiteFileBackTest,reportFileBackTest){


    println "+++++ starting backward Compatibility tests"
    try {


        sh "xvfb-run mvn clean -pl backward test -Denv=${environment} -Dlocale=IN -Dsurefire.suiteXmlFiles=src/test/resources/IN/suites/${suiteFileBackTest}"

        def resultJson = readJSON text: '{}'

        resultJson = extractSuiteResult("backward",suiteFileBackTest)

        if (resultJson.fails > 0) {
            resultJson.status = "FAIL"
        } else {
            resultJson.status = "PASS"
        }

        ciPipelineQAJSON.backwardTest = resultJson


    } catch (ex) {
        println "Error in test executeBackwardTest"

        println ex

        def xmlFilePath = getPwd() + "/backward/target/suite_result.txt"

        def resultJson = readJSON text: '{}'

        def exists = fileExists xmlFilePath

        if (exists){
            println "suite_result file exists"
            resultJson = extractSuiteResult("backward",suiteFileBackTest)
        }
        else {
            resultJson.fails = 1 as int
            resultJson.status = "FAIL"
            resultJson.report = "Error in test executeBackwardTest" as String
        }

        ciPipelineQAJSON.backwardTest = resultJson
        return ciPipelineQAJSON
    }
    return ciPipelineQAJSON

}

private executeProdSanityTest(suiteFileBackTest,reportFileBackTest){


    println "+++++ starting ProdSanity tests"
    try {


        sh "xvfb-run mvn clean -pl prodSanity test -Denv=${ipAddress} -Dlocale=IN -Dsurefire.suiteXmlFiles=src/test/resources/IN/suites/${suiteFileBackTest}"

        def resultJson = readJSON text: '{}'

        resultJson = extractSuiteResult("prodSanity",suiteFileBackTest)

        if (resultJson.fails > 0) {
            resultJson.status = "FAIL"
        } else {
            resultJson.status = "PASS"
        }

        ciPipelineQAJSON.prodSanity = resultJson


    } catch (ex) {
        println "Error in test executeProdSanity"

        println ex

        def xmlFilePath = getPwd() + "/prodSanity/target/suite_result.txt"

        def resultJson = readJSON text: '{}'

        def exists = fileExists xmlFilePath

        if (exists){
            println "suite_result file exists"
            resultJson = extractSuiteResult("prodSanity",suiteFileBackTest)

        }
        else {
            resultJson.fails = 1 as int
            resultJson.status = "FAIL"
            resultJson.report = "Error in test executeProdSanity" as String
        }

        ciPipelineQAJSON.prodSanity = resultJson
        return ciPipelineQAJSON
    }
    return ciPipelineQAJSON

}

private executeFunctionalAppTest(suiteFileAppTest,reportFileAppTest){


        println "+++++ starting FunctionalApp tests"
        try {

            sh "mvn clean -pl mobileapp test -Denv=${environment} -Dlocale=IN -Dsurefire.suiteXmlFiles=src/test/resources/IN/suites/${suiteFileAppTest}"

            def resultJson = readJSON text: '{}'

            resultJson = extractSuiteResult("mobileapp",suiteFileAppTest)

            if (resultJson.fails > 0) {
                resultJson.status = "FAIL"
            } else {
                resultJson.status = "PASS"
            }

            ciPipelineQAJSON.appTest = resultJson


        } catch (ex) {
            println "Error in test executeFunctionalAppTest"

            println ex

            def xmlFilePath = getPwd() + "/mobileapp/target/suite_result.txt"

            def resultJson = readJSON text: '{}'

            def exists = fileExists xmlFilePath

            if (exists){
                println "suite_result file exists"
                resultJson = extractSuiteResult("mobileapp",suiteFileAppTest)
            }
            else {
                resultJson.fails = 1 as int
                resultJson.status = "FAIL"
                resultJson.report = "Error in test executeFunctionalAppTest" as String
            }

            ciPipelineQAJSON.appTest = resultJson
            return ciPipelineQAJSON



        }

    return ciPipelineQAJSON
}

private String getPwd(){
    return sh ( script: "pwd", returnStdout: true ).trim()
}
private String manualQaSignOff(){

    def userInput = input(
            id: 'userInput', message: 'manual sign off?', ok: 'SIGN OFF!',
            parameters: [
            choice(name: 'QA sign off', choices: "Yes\nNo", description: 'All tests passed ? yes/no')
    ])

    println " userInput manual QA choice ++++++++++++++++ :" + userInput

    return userInput

}


private void readRepoProperties() {
    configFileProvider(
            [configFile(fileId: 'repo_file_config', variable: 'REPO_FILE_CONFIG')]) {
        echo "File : $REPO_FILE_CONFIG"

        def props = readJSON file: "$REPO_FILE_CONFIG"

        def repoConfig = props[repository]

        if (repoConfig != null) {

            def repo = repoConfig["repo"]
            def suiteFileIntegration = repoConfig["suiteIntegration"]
            def suiteFileWebTest = repoConfig["suiteWebTest"]
            def suiteFileAppTest = repoConfig["suiteAppTest"]
            def reportFileIntegration = repoConfig["reportIntegration"]
            def reportFileWebTest = repoConfig["reportWebTest"]
            def reportFileAppTest = repoConfig["reportAppTest"]
            autoDeploy = repoConfig["autoDeploy"]

            println "suiteFileIntegration" + suiteFileIntegration

            }
        }
    }

private String extractSuiteResult(suiteType,suiteFileBackTest){

    def jsonFilePath = getPwd() + "/" + suiteType + "/target/suite_result.txt"

    def props = readJSON file: jsonFilePath

    def resultJson = readJSON text: '{}'

    resultJson.suiteName = suiteFileBackTest as String
    resultJson.totalTests = props["Total"] as int
    resultJson.fails = props["Failed"] as int
    resultJson.skipped = props["Skipped"] as int
    resultJson.report = props["ReportLink"] as String

    println "+++++++extractSuiteResult"

    println props

    return resultJson
}

private boolean reportFileExists(suiteType){

    def xmlFilePath = getPwd() + "/webapp/target/suite_result.txt"

    def resultJson = readJSON text: '{}'

    def exists = fileExists xmlFilePath

    if (exists){
        println "suite_result file exists"
    }
}