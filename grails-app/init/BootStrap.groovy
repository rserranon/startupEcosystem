import startupecosystem.*

class BootStrap {

    def init = { servletContext ->

		// Cargar las estapas principales
		ProjectStage ps1 = new ProjectStage(projectStage: "Idea").save()
		ProjectStage ps2 = new ProjectStage(projectStage: "Launch").save()
		ProjectStage ps3 = new ProjectStage(projectStage: "Growth").save()
		ProjectStage psEv = new ProjectStage(projectStage: "Evangelists").save()	
		
		// cargar las fases
		Phase ideaPh1 = new Phase(phaseName: "Inspire", projectstage: 	[ps1]).save()
		Phase ideaPh2 = new Phase(phaseName: "Educate", projectstage: 	[ps1]).save()
		Phase ideaPh3 = new Phase(phaseName: "Validate", projectstage: 	[ps1]).save()		
		// cargar las fases
		Phase launchPh1 = new Phase(phaseName: "Start", projectstage: 	[ps2]).save()
		Phase launchPh2 = new Phase(phaseName: "Develop", projectstage: [ps2]).save()
		Phase launchPh3 = new Phase(phaseName: "Launch", projectstage: 	[ps2]).save()
		// cargar las fases
		Phase growthPh1 = new Phase(phaseName: "Recognition", projectstage: [ps3]).save()
		Phase growthPh2 = new Phase(phaseName: "Funding", projectstage: 	[ps3]).save()
		Phase growthPh3 = new Phase(phaseName: "Growth",  projectstage: 	[ps3]).save()
		// cargar las fases
		Phase evPh1 	= new Phase(phaseName: "N/A", 	  projectstage: 	[psEv]).save()
		
		Taxonomy tx1 = new Taxonomy(taxonomyName: "Startup Media", 	 phase: [ideaPh1]).save()		
		Taxonomy t0  = new Taxonomy(taxonomyName: "Twitter Taxonomy", phase: [evPh1]).save()
		
		Resource rStMedia1 = new Resource(resourceName: "Early Adopters", resourceURL: "http://earlyadopters.mx/",	twitterAcct: "N/A",				 taxonomy: [tx1]).save()
		Resource rStMedia2 = new Resource(resourceName: "Emprendela", 	  resourceURL: "http://emprende.la/",		 twitterAcct: "N/A",				 taxonomy: [tx1]).save()		
		Resource rSMedia3  = new Resource(resourceName: "Invent", 		  resourceURL: "http://invent.mx/",			twitterAcct: "N/A",				taxonomy: [tx1]).save()		
		Resource rsTw1 	   = new Resource(resourceName: "Roberto Serrano",resourceURL: "", 							twitterAcct: "@StartupsPal",	taxonomy:  [t0]).save()
		
    }
    def destroy = {
    }
}
