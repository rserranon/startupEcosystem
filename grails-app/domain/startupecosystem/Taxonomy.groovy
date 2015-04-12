package startupecosystem

class Taxonomy {
	
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
