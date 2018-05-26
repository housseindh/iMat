package org.imat.restapi;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.imat.module.OntologyChainAnalysis;
import org.imat.module.RequestAnalyzer;

@Path("")
@Stateless
public class MainSearch {

	@EJB
	OntologyChainAnalysis ontologyChainAnalysis; 
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("")
	public String search(@QueryParam("query") String input){
		String result = "";
		RequestAnalyzer requestAnalyzer = new RequestAnalyzer(ontologyChainAnalysis.getOntologyManager(), ontologyChainAnalysis.getMatching());
		try {
			result = requestAnalyzer.search(input, ontologyChainAnalysis.getTable());
		} catch (Exception e) {
				e.printStackTrace();
		}
		return result ;
	}
}
