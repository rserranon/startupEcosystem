package startupecosystem

class Resource {
	static belongsTo = [taxonomy: Taxonomy]
	
	String resourceName
	String resourceURL
	String twitterAcct
	
    static constraints = {
		resourceName blank: false
		resourceURL  url: true, nullable: true, blank: true
		twitterAcct  nullable: true, blank: true
    }
	
	static mapping = {
	        
	    }
	
	String toString() {
	    return this.resourceName;
	}
}
