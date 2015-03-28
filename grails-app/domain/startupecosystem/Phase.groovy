package startupecosystem

class Phase {
	static belongsTo = [projectstage: ProjectStage]
	
	String phaseName
	
	static hasMany = [taxonomies: Taxonomy]

    static constraints = {
    }
	
	String toString() {
	    return this.phaseName;
	}
}
