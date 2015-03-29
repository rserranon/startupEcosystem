<!doctype html>
<html>
    <head>
        <meta name="layout" content="main"/>
        <title>Welcome to Grails</title>
        <style type="text/css" media="screen">
            #status {
                background-color: #eee;
                border: .2em solid #fff;
                margin: 2em 2em 1em;
                padding: 1em;
                width: 12em;
                float: left;
                -moz-box-shadow: 0px 0px 1.25em #ccc;
                -webkit-box-shadow: 0px 0px 1.25em #ccc;
                box-shadow: 0px 0px 1.25em #ccc;
                -moz-border-radius: 0.6em;
                -webkit-border-radius: 0.6em;
                border-radius: 0.6em;
            }

            #status ul {
                font-size: 0.9em;
                list-style-type: none;
                margin-bottom: 0.6em;
                padding: 0;
            }

            #status li {
                line-height: 1.3;
            }

            #status h1 {
                text-transform: uppercase;
                font-size: 1.1em;
                margin: 0 0 0.3em;
            }

            #page-body {
                margin: 2em 1em 1.25em 18em;
            }

            h2 {
                margin-top: 1em;
                margin-bottom: 0.3em;
                font-size: 1em;
            }

            p {
                line-height: 1.5;
                margin: 0.25em 0;
            }

            #controller-list ul {
                list-style-position: inside;
            }

            #controller-list li {
                line-height: 1.3;
                list-style-position: inside;
                margin: 0.25em 0;
            }

            @media screen and (max-width: 480px) {
                #status {
                    display: none;
                }

                #page-body {
                    margin: 0 1em 1em;
                }

                #page-body h1 {
                    margin-top: 0;
                }
            }
        </style>
    </head>
    <body>
		
        <div id="controller-list" role="navigation">
            <h2>Available Controllers:</h2>
            <ul>
                <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                    <li class="controller"><g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link></li>
                </g:each>
            </ul>
        </div>
								

		<!--
			Begin Pure.css  
		<!-->
			
			<div class="pure-menu pure-menu-horizontal">
				<a href="#" class="pure-menu-heading">Your Logo</a>
				<ul class="pure-menu-list">
					<li class="pure-menu-item"><a href="#" class="pure-menu-link">Home</a></li>
					<li class="pure-menu-item pure-menu-selected"><a href="#" class="pure-menu-link">Manage Stages</a></li>
					<li class="pure-menu-item"><a href="#" class="pure-menu-link">Manage Ecosystem Participants</a></li>
				</ul>
			</div>

			<div class="banner">
				<h1 class="banner-head">
					Startup Ecosystem Canvas:<br>
					Mexico
				</h1>
			</div>

			<div class="l-content">
				<div class="pure-u-1 pure-u-md-3-4">
					<div class= "stage-table stage-table-idea">
						<div class="stage-table-header">
							<span class="stage-table-price">
								1. 								
							</span>
							<h2>Idea</h2>
						</div>
					</div>		
				</div>
				<div class="stages-tables pure-g"> 
										
					<div class="pure-u-1 pure-u-md-1-4">
						<!-- begin Inspire -->
						<div class="stage-table stage-table-inspire">
							<div class="stage-table-header">							
								<span class="stage-table-price">
									1. 								
								</span>
								<h2>Inspire</h2>
							</div>

							<ul class="stage-table-list">
								<g:each var="r" in="${startupecosystem.Resource.findAll()}" >	
								     <li>
										 <a href="${r.resourceURL}">${r.resourceName}</a>										 
									 </li>
								</g:each>
							</ul>

							<button class="button-choose pure-button">Choose</button>
						</div> <!-- end Inspire -->	 
					</div>
					<div class="pure-u-1 pure-u-md-1-4">
						<!-- begin Educate -->
						<div class="stage-table stage-table-educate stage-table-selected">
							<div class="stage-table-header">
								<span class="stage-table-price">
									2.
								</span>
								<h2>Educate</h2>
							</div>
							<ul class="stage-table-list">
								<g:each var="r" in="${startupecosystem.Resource.findAll()}" >	
								     <li>
										 <a href="${r.resourceURL}">${r.resourceName}</a>										 
									 </li>
								</g:each>
							</ul>
							<button class="button-choose pure-button">Choose</button>
						</div> <!-- end Educate -->
					</div>
					<div class="pure-u-1 pure-u-md-1-4">
						<!-- begin Validate -->
						<div class="stage-table stage-table-validate">
							<div class="stage-table-header">
								<span class="stage-table-price">
									3.
								</span>
								<h2>Validate</h2>							
							</div>

							<ul class="stage-table-list">
								<g:each var="r" in="${startupecosystem.Resource.findAll()}" >	
								     <li>
										 <a href="${r.resourceURL}">${r.resourceName}</a>										 
									 </li>
								</g:each>
							</ul>

							<button class="button-choose pure-button">Choose</button>
						</div> <!-- end Validate -->
						
					</div>					
					<div class="pure-u-1 pure-u-md-2-24 fondo">
					</div>	
					<div class="pure-u-1 pure-u-md-1-6">
						<div class="stage-table stage-table-evangelists">
							<ul class="stage-table-list">
								<g:set var="list" value="${startupecosystem.Taxonomy.findByTaxonomyName("Twitter Taxonomy").getResources()}" scope="page"/>
								${list}
								<g:each var="r" in="${list}">	
								     <li>
										 <a href="http://www.twitter.com/${r.twitterAcct}">${r.resourceName}</a>										 
									 </li>
								</g:each>
							</ul>
							<button class="button-choose pure-button">Choose</button>
						</div>
					</div>					
				</div>
			</div> <!-- end l-content -->

		<div class="footer l-box">		
		</div>						
						
    </body>
</html>
