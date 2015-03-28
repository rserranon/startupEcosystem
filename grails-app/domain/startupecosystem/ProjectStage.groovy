package startupecosystem

class ProjectStage {

	String projectStage
	
	static hasMany = [phases: Phase]
	
    static constraints = {
    }
	
	String toString() {
	    return this.projectStage;
	}
}
