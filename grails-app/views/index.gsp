<!doctype html>
<html>
    <head>
        <title>Startup Ecosystem Canvas Mexico</title>
		<asset:stylesheet src="pure-release-0.6.0/pure-min.css"/>
		<asset:stylesheet src="pure-release-0.6.0/grids-responsive-min.css"/>
		<asset:stylesheet src="pure-layout-stage/stage.css"/>		
		<meta name="viewport" content="width=device-width, initial-scale=1.0">		
    </head>
    <body class="pure-g" >	
		
        <div calss="pure-u-1">
            <h2>Available Controllers:</h2>
                <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                    <li style="letter-spacing: 0em;"><g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link></li>
                </g:each>
        </div>
		
		
			
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
									<g:each var="phase" in="${pStage.getPhases()}">
										<div class="pure-u-23-24 pure-u-md-1-3 stage-table-inspire">  
											<h2>${phase.phaseNumber}. ${phase.phaseName}</h2>
											<ul class="stage-table-list">
											<g:set var="taxonomiesList" value="${phase.getTaxonomies()}" scope="page"/>
												<g:each var="t" in="${taxonomiesList}">
													<b><li>${t.taxonomyName}</li></b>	
													<g:each var="r" in="${t.resources}">	
														<li>
															<a href="${r.resourceURL}">${r.resourceName}</a>										 
														</li>
													</g:each>
												</g:each>	
											</ul>
										</div>	
									</g:each>	
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
