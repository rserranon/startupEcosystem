package startupecosystem

class Taxonomy {
	static belongsTo = [phase: Phase, metaresource: MetaResource]
	
	String taxonomyName
	
	static hasMany = [resources: Resource]

    static constraints = {
		
		phase validator: { val, obj ->
		                if (obj.phase && obj.metaresource) {     // one must be null
							return ['only one: Phase or metaRerource can be selected']
						}	                             
		        }
		
		// TODO Implement custom validator
		taxonomyName blank:false
		resources nullable: true
		phase nullable: true
		metaresource nullable: true
    }
	
	String toString() {
		// validate for null
		if (this.phase) {
				return this.phase.projectstage.toString() + "->" + this.phase.toString()  + " ->" + this.taxonomyName
		} else {
				return this.metaresource.toString()  + " ->" + this.taxonomyName
		}
	}
}
