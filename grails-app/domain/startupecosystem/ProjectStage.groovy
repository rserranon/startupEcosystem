package startupecosystem

class ProjectStage {

	String	stageNumber
	String 	projectStage
	
	static hasMany = [phases: Phase]
	
    static constraints = {
		stageNumber nullable: false, blank:true
		projectStage blank: false
		phases nullable: true
    }
	
	String toString() {
	    return this.stageNumber + ". "+ this.projectStage;
	}
}
