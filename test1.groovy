node {
  try {
    notifyStarted()
// sadasdsa
    notifySuccessful()
  } 
  
  catch (e) {
    currentBuild.result = "FAILED"
    notifyFailed()
    throw e
  }
}

def notifyStarted() { /* .. */ }

def notifySuccessful() { /* .. */ }

def notifyFailed() {

  emailext (
      
    )
}


        // stage('mail notification') {
        //     emailext body: 'need attention', subject: 'jenkins job', to: 'baurzhansiit@gmail.com'
        // }
        // currentBuild.result = "FAILED"
        // notifyFailed()

        mail bcc: '', 
        body: "Check console output at '${env.BUILD_URL}' error output = ${err}", 
        cc: '', from: '', replyTo: '', subject: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'", 
            to: 'baurzhansiit@gmail.com'
        // emailext body: "${err}", subject: 'fail', to: 'baurzhansiit@gmail.com'

java.lang.NoSuchMethodError: No such DSL method 'call' found among steps [ansiColor, archive, bat, build, catchError, checkout, compareVersions,
 deleteDir, dir, dockerFingerprintFrom, dockerFingerprintRun,
 echo, emailext, emailextrecipients, envVarsForTool, error, fileExists, findBuildScans, findFiles, getContext, git, input, isUnix, junit,
 library, libraryResource, load, lock, mail, milestone, node, nodesByLabel, parallel, powershell, properties, publishChecks, pwd, pwsh, readCSV, 
readFile, readJSON, readManifest, readMavenPom, readProperties, readTrusted, readYaml, resolveScm, retry, script, sh, sha1, sleep, stage, stash, 
step, tee, timeout, timestamps, tm, tool, touch, unarchive, unstable, unstash, unzip, validateDeclarativePipeline, waitUntil, warnError,
 withChecks, withContext, withCredentials, withDockerContainer, withDockerRegistry, withDockerServer, withEnv, withGradle, wrap, writeCSV, 
writeFile, writeJSON, writeMavenPom, writeYaml, ws, zip] or symbols [all, allBranchesSame, allOf, always, ant, antFromApache, antOutcome, antTarget, 
any, anyOf, apiToken, architecture, archiveArtifacts, artifactManager, authorizationMatrix, batchFile, booleanParam, branch, brokenBuildSuspects, 
brokenTestsSuspects, buildButton, buildDiscarder, buildDiscarders, buildRetention, buildTimestamp, buildTimestampExtraProperties, buildUser,
 buildingTag, caseInsensitive, caseSensitive, certificate, changeRequest, changelog, changeset, checkoutToSubdirectory, choice, choiceParam,
 cleanWs, clock, command, credentials, cron, crumb, culprits, defaultFolderConfiguration, defaultView, demand, developers, disableConcurrentBuilds, 
disableResume, docker, dockerCert, dockerServer, dockerTool, dockerfile, downstream, dumb, durabilityHint, email-ext, envVars, 
envVarsFilter, environment, equals, expression, file, fileParam, filePath, fingerprint, fingerprints, frameOptions, freeStyle, freeStyleJob, 
fromDocker, fromScm, fromSource, git, gitBranchDiscovery, gitHubBranchDiscovery, gitHubBranchHeadAuthority, gitHubExcludeArchivedRepositories, 
gitHubExcludePublicRepositories, gitHubForkDiscovery, gitHubPullRequestDiscovery, gitHubSshCheckout, gitHubTagDiscovery,
 gitHubTopicsFilter, gitHubTrustContributors, gitHubTrustEveryone, gitHubTrustNobody, gitHubTrustPermissions, gitTagDiscovery, github, githubPush,
 gradle, headRegexFilter, headWildcardFilter, hyperlink, hyperlinkToModels, inheriting, inheritingGlobal, installSource, isRestartedRun, jdk, 
jdkInstaller, jgit, jgitapache, jnlp, jobBuildDiscarder, jobName, junitTestResultStorage, label, lastDuration, lastFailure, lastGrantedAuthorities, 
lastStable, lastSuccess, legacy, legacySCM, list, local, location, logRotator, loggedInUsersCanDoAnything, mailer, masterBuild, maven,
 maven3Mojos, mavenErrors, mavenGlobalConfig, mavenMojos, mavenWarnings, modernSCM, myView, namedBranchesDifferent, newContainerPerStage, node, 
nodeProperties, nonInheriting, none, not, overrideIndexTriggers, paneStatus, parallelsAlwaysFailFast, parameters, password, pattern, permanent, 
pipeline-model, pipeline-model-docker, pipelineTriggers, plainText, plugin, pollSCM, preserveStashes, projectNamingStrategy, proxy, pruneTags, 
queueItemAuthenticator, quietPeriod, rateLimit, rateLimitBuilds, recipients, requestor, resourceRoot, retainOnlyVariables, run, runParam, 
sSHLauncher, schedule, scmRetryCount, scriptApproval, scriptApprovalLink, search, security, shell, simpleBuildDiscarder, skipDefaultCheckout,
 skipStagesAfterUnstable, slave, sourceRegexFilter, sourceWildcardFilter, ssh, sshPublicKey, sshUserPrivateKey, standard, status, string,
 stringParam, suppressAutomaticTriggering, swapSpace, tag, teamSlugFilter, text, textParam, timestamper, timestamperConfig, timezone, tmpSpace, 
toolLocation, triggeredBy, unsecured, untrusted, upstream, upstreamDevelopers, userSeed, usernameColonPassword, usernamePassword, viewsTabBar, 
weather, withAnt, x509ClientCert, zip] or globals [currentBuild, docker, env, mypipeline, opstreePipeline, params, pipeline, pipelineConfig, scm
