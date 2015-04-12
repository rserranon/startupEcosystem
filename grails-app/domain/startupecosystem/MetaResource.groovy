package startupecosystem

class MetaResource {
	
	String metaResource
	
	
	static hasMany = [taxonomies: Taxonomy]

    static constraints = {
		metaResource blank: false;
    }
	
	String toString() {
	    return this.metaResource;
	}
}


