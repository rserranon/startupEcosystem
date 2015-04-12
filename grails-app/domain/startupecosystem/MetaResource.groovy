package startupecosystem

class MetaResource {
	
	String metaName
	
	
	static hasMany = [taxonomies: Taxonomy]

    static constraints = {
		metaName blank: false;
    }
	
	String toString() {
	    return this.metaName;
	}
}


