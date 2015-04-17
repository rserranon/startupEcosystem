package startupecosystem

class Taxonomy {
	static belongsTo = [phase: Phase, metaresource: MetaResource]
	
	String taxonomyName
	
	static hasMany = [resources: Resource]

    static constraints = {
		taxonomyName blank:false
		resources nullable: true
		phase nullable: true
		metaresource nullable: true
    }
	
	String toString() {
	    return  (this.phase.toString() ?: '') + " " + (this.metaresource.toString() ?: '') + " " + this.taxonomyName;
	}
}
