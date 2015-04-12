package startupecosystem

class Resource {
	static belongsTo = [taxonomy: Taxonomy]
	
	String resourceName
	String resourceURL
	String twitterAcct
	
    static constraints = {
		resourceName blank: false
		resourceURL  url: true, blank: true
		twitterAcct  blank: true
    }
	
	static mapping = {
	        sort "resourceName"
	    }
	
	String toString() {
	    return this.resourceName;
	}
}
