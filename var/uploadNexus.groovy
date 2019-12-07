/*
Nexus Uploader function

Upload given artifact into the given Nexus Repository.
Params: 
    nUser:          Nexus Username
    nPass:          Nexus Password
    nRepo:          Nexus Repository URL
    nArtifact:      Artifact to upload (in the current folder)

*/
def call(Map config) {
    state = 9

    if ( !config['nUser']) {
        print "No Nexus username provided! Please set the nUser parameter!"
        state = 11
        return state
    }
    if ( !config['nPass']) {
        print "No Nexus password provided! Please set the nPass parameter!"
        state = 12
        return state
    }
        if ( !config['nRepo']) {
        print "No Nexus Repository provided! Please set the nRepo parameter!"
        state = 13
        return state
    }
        if ( !config['nArtifact']) {
        print "No Artifact provided! Please set the nArtifact parameter!"
        state = 14
        return state
    }

    CURL_EXIST = sh (script: "which curl", returnStatus: true )
        CURL_COMMAND = "curl -w '%{http_code}' -u '${config['nUser']}:${config['nPass']}' --upload-file '${config['nArtifact']}' '${config['nRepo']}/${config['nArtifact']}' "
    if ( CURL_EXIST == 0 ) {
        
    } else {
        print "No CURL command available! Aborting."
        state = 15  
        return state
    }


    



    return state
}