package startupecosystem

class Taxonomy {
	static belongsTo = [phase: Phase]
	
	String taxonomyName
	
	static hasMany = [resources: Resource]

    static constraints = {
		taxonomyName blank:false
		phase nullable: false
		resources nullable: true
    }
	
	String toString() {
	    return this.taxonomyName;
	}
}
