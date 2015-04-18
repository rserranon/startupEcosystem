package startupecosystem

class ProjectStage {
	
	MetaResource metaResource
	
	String	stageNumber
	String 	projectStage
	
	static hasMany = [phases: Phase]
	
	
    static constraints = {
		stageNumber nullable: false, blank:true
		projectStage blank: false
		metaResource nullable: true
		phases nullable: true
    }
	
	String toString() {
	    return this.stageNumber + ". "+ this.projectStage;
	}
}
