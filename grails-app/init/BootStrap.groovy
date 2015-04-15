import startupecosystem.*

class BootStrap {

    def init = { servletContext ->
		
		
		// Taxonomy tx1 = new Taxonomy(taxonomyName: "Startup Media").save()		
		// Taxonomy t0  = new Taxonomy(taxonomyName: "Twitter Taxonomy").save()
		
		// cargar las fases
		// Phase ideaPh1 = new Phase(phaseNumber: "1", phaseName: "Inspire", taxonomies: 	[[tx1]]).save()
		// Phase ideaPh2 = new Phase(phaseNumber: "2", phaseName: "Educate", taxonomies: 	[[tx1]]).save()
		// Phase ideaPh3 = new Phase(phaseNumber: "3", phaseName: "Validate", taxonomies: 	[[tx1]]).save()		
		// cargar las fases
		// Phase launchPh1 = new Phase(phaseNumber: "1", phaseName: "Start", taxonomies: 	[[tx1]]).save()
		// Phase launchPh2 = new Phase(phaseNumber: "2", phaseName: "Develop", taxonomies: [[tx1]]).save()
		// Phase launchPh3 = new Phase(phaseNumber: "3", phaseName: "Launch", taxonomies: 	[[tx1]]).save()
		// cargar las fases
		// Phase growthPh1 = new Phase(phaseNumber: "1", phaseName: "Recognition", taxonomies: [[tx1]]).save()
		// Phase growthPh2 = new Phase(phaseNumber: "2", phaseName: "Funding", taxonomies: 	[[tx1]]).save()
		// Phase growthPh3 = new Phase(phaseNumber: "3", phaseName: "Growth",  taxonomies: 	[[tx1]]).save()
		// cargar las fases
		// MetaResource mR1 	= new MetaResource(metaName: "Evangelists",  taxonomies: 	[t0]).save()
		
		// Cargar las estapas principales
		// ProjectStage ps1 = new ProjectStage(stageNumber: "1", projectStage: "Idea",   phases: [ideaPh1]).save()
		// ProjectStage ps2 = new ProjectStage(stageNumber: "2", projectStage: "Launch", phases: [ideaPh2]).save()
		// ProjectStage ps3 = new ProjectStage(stageNumber: "3", projectStage: "Growth", phases: [ideaPh3]).save()
		// ProjectStage psEv = new ProjectStage(projectStage: "Global Resources").save()	
		
		
		
		// Resource rStMedia1 = new Resource(resourceName: "Early Adopters", resourceURL: 			"http://earlyadopters.mx/",		twitterAcct: "N/A",				taxonomy: [tx1]).save()
		// Resource rStMedia2 = new Resource(resourceName: "Emprendela", 	  resourceURL: 			"http://emprende.la/",			twitterAcct: "N/A",				taxonomy: [tx1]).save()		
		// Resource rSMedia3  = new Resource(resourceName: "Invent", 		  resourceURL: 			"http://invent.mx/",			twitterAcct: "N/A",				taxonomy: [tx1]).save()		
		// Resource rsTw1 	   = new Resource(resourceName: "Roberto Serrano",resourceURL: 			"http://www.startupspal.com", 	twitterAcct: "@StartupsPal",	taxonomy:  [t0]).save()
		// Resource rsTw2 	   = new Resource(resourceName: "Fernando Lelo de la Rea",resourceURL: 	"http://www.startupspal.com", 	twitterAcct: "@Ferlelo",		taxonomy:  [t0]).save()
		// Resource rsTw3 	   = new Resource(resourceName: "Cesar Salazar",resourceURL: 			"http://www.startupspal.com", 	twitterAcct: "@Cesarsalazar",	taxonomy:  [t0]).save()
		// Resource rsTw4 	   = new Resource(resourceName: "Claudio Cossio",resourceURL: 			"http://www.startupspal.com", 	twitterAcct: "@CCossio",		taxonomy:  [t0]).save()
		// Resource rsTw5 	   = new Resource(resourceName: "Roberto Serrano",resourceURL: 			"http://www.startupspal.com", 	twitterAcct: "@StartupsPal",	taxonomy:  [t0]).save()
		// Resource rsTw6 	   = new Resource(resourceName: "Fernando Lelo de la Rea",resourceURL: 	"http://www.startupspal.com", 	twitterAcct: "@Ferlelo",		taxonomy:  [t0]).save()
		// Resource rsTw7 	   = new Resource(resourceName: "Cesar Salazar",resourceURL: 			"http://www.startupspal.com", 	twitterAcct: "@Cesarsalazar",	taxonomy:  [t0]).save()
		// Resource rsTw8 	   = new Resource(resourceName: "Claudio Cossio",resourceURL: 			"http://www.startupspal.com", 	twitterAcct: "@CCossio",		taxonomy:  [t0]).save()		
		// Resource rsTw9 	   = new Resource(resourceName: "Roberto Serrano",resourceURL: 			"http://www.startupspal.com", 	twitterAcct: "@StartupsPal",	taxonomy:  [t0]).save()
		// Resource rsTw10    = new Resource(resourceName: "Fernando Lelo de la Rea",resourceURL: 	"http://www.startupspal.com", 	twitterAcct: "@Ferlelo",		taxonomy:  [t0]).save()
		// Resource rsTw11    = new Resource(resourceName: "Cesar Salazar",resourceURL: 			"http://www.startupspal.com", 	twitterAcct: "@Cesarsalazar",	taxonomy:  [t0]).save()
		// Resource rsTw12    = new Resource(resourceName: "Claudio Cossio",resourceURL: 			"http://www.startupspal.com", 	twitterAcct: "@CCossio",		taxonomy:  [t0]).save()		
		

    }
    def destroy = {
    }
}
