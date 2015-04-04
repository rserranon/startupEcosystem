package startupecosystem

class Resource {
	static belongsTo = [taxonomy: Taxonomy]
	
	String resourceName
	String resourceURL
	String twitterAcct
	
    static constraints = {
		resourceName blank: false
		resourceURL  url: true
		twitterAcct  blank: false
    }
	
	static mapping = {
	        sort "resourceName"
	    }
	
	String toString() {
	    return this.resourceName;
	}
}
