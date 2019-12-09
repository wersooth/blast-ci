
def call(String toolname) {    
    return sh(script: "which $toolname", returnStatus: true)
}