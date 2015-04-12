<!doctype html>
<html>
    <head>
        <title>Welcome to Grails</title>
		<asset:stylesheet src="pure-release-0.6.0/pure-min.css"/>
		<asset:stylesheet src="pure-release-0.6.0/grids-responsive-min.css"/>
		<asset:stylesheet src="pure-layout-stage/stage.css"/>		
		<meta name="viewport" content="width=device-width, initial-scale=1.0">		
    </head>
    <body class="pure-g" >		
		<div class="banner">
			<h1 class="banner-head">
				Startup Ecosystem Canvas:<br>
				Mexico
			</h1>
		</div>				
		<g:set var="projectStageList" value="${startupecosystem.ProjectStage.findAll()}" scope="page"/>
		<g:each var="pStage" in="${projectStageList}">		
			<div class="pure-u-1 pure-u-md-1 main-content">
				<div class="pure-u-md-3-5 stage-table stage-table-header-${pStage.projectStage.toLowerCase()}"> <!-- bloque de 3 etapas -->
					<div class="pure-g pure-u-1">
						
							<h2>${pStage.projectStage}</h2>
								<div class="pure-g"> <!-- grid de fases -->	
									<div class="pure-u-23-24 pure-u-md-1-3 stage-table-inspire">  
										<h2>1. Inspire</h2>
										<g:set var="inspireList" value="${startupecosystem.Taxonomy.findByTaxonomyName("Twitter Taxonomy").getResources()}" scope="page"/>
										<ul class="stage-table-list">	
											<g:each var="r" in="${inspireList}">	
												<li>
													<a href="${r.resourceURL}">${r.resourceName}</a>										 
												</li>
											</g:each>
										</ul>
									</div>	
									<div class="pure-u-23-24 pure-u-md-1-3 stage-table-educate">
										<h2>2. Educate</h2>
										<ul class="stage-table-list">	
											<li>Roberto Serrano</li>
										</ul>
									</div>	
									<div class="pure-u-23-24 pure-u-md-1-3 stage-table-validate">
										<h2>3. Validate</h2>
										<ul class="stage-table-list">	
											<li>Roberto Serrano</li>
										</ul>
									</div>
								</div>	<!-- end pure-g grid de fases -->	
					</div> <!-- end pure-g pure-u-1 pure-u-md-1 -->	
				</div>	
				<div class="pure-u-md-2-24 stage-table stage-table-evangelists fondo">
				
				</div>	
				<div class="pure-u-md-5-24 stage-table stage-table-list lista-evangelistas">
					<table class"pure-table stage-table-list">
						<tr>
						    <th>Nombre</th>
						    <th>twitter</th>
						 </tr>
						<g:set var="list" value="${startupecosystem.Taxonomy.findByTaxonomyName("Twitter Taxonomy").getResources().sort()}" scope="page"/>
						<g:each var="r" in="${list}">	
						<tr>
							<td>
								${r.resourceName}										 
							</td>
							<td>
								<a href="http://www.twitter.com/${r.twitterAcct}">${r.twitterAcct}</a>
							</td>	
						</tr>		
						</g:each>
					</table>					
				</ul>		
			</div>	
		</g:each>					
    </body>
</html>
