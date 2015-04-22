package startupecosystem

class Taxonomy {
	static belongsTo = [phase: Phase, metaresource: MetaResource]
	
	String taxonomyName
	
	static hasMany = [resources: Resource]

    static constraints = {
		
		
		
		
		taxonomyName blank:false
		resources nullable: true
		phase nullable: true
		// TODO Improve custom validator
		phase validator: { val, obj ->
		                if (obj.phase && obj.metaresource) {     // one must be null
							return ['only one: Phase or metaRerource can be selected']
						}	                             
		        }		
		metaresource nullable: true
    }
	
	String toString() {
		// validate for null
		if (this.phase) {
				return this.phase.toString()  + " ->" + this.taxonomyName
		} else {
				return this.metaresource.toString()  + " ->" + this.taxonomyName
		}
	}
}
