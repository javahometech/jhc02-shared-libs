def call(creds,tomcatIp,userName,warName){
  sshagent([creds]) {
    // copy war file to tomcat webapps folder
    sh "scp target/${warName}.war ${userName}@${tomcatIp}:/opt/tomcat9/webapps/"
    sh "ssh ${userName}@${tomcatIp} /opt/tomcat9/bin/shutdown.sh"
    sh "ssh ${userName}@${tomcatIp} /opt/tomcat9/bin/startup.sh"
  }
}
