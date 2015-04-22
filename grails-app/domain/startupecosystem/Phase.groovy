package startupecosystem

class Phase {
	static belongsTo = [projectstage: ProjectStage]
	
	String	phaseNumber
	String  phaseName
	
	static hasMany = [taxonomies: Taxonomy]

    static constraints = {
		phaseNumber blank: false;
		phaseName	blank: false;
    }
	
	String toString() {
	    return this.projectstage.toString() + "-> " + this.phaseNumber + ". "+ this.phaseName;
	}
}
