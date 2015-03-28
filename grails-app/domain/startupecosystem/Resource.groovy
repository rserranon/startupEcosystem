package startupecosystem

class Resource {
	static belongsTo = [taxonomy: Taxonomy]
	
	String resourceName
	String resourceURL
	String twitter
	
    static constraints = {
    }
	
	String toString() {
	    return this.resourceName;
	}
}
