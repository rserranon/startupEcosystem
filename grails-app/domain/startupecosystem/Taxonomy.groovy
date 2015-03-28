package startupecosystem

class Taxonomy {
	static belongsTo = [phase: Phase]
	
	String taxonomyName
	
	static hasMany = [resources: Resource]

    static constraints = {
    }
	
	String toString() {
	    return this.taxonomyName;
	}
}
