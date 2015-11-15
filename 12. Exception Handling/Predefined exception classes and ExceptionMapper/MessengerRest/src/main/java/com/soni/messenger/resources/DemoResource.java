package com.soni.messenger.resources;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;


@Produces(value=MediaType.TEXT_PLAIN)
@Consumes(value=MediaType.TEXT_PLAIN)
@Path(value="/inject")
public class DemoResource {

	@GET
	@Path(value="/annotations")
	public String annotations(@BeanParam FilterBean filterBean) {
		return "Matrix Param  : " + filterBean.metrixParam + "\nHeader Param : " + filterBean.headerParam + "\nCookie Param : " + filterBean.cookieParam;
	}
	
	@GET
	@Path(value="/context")
	public String context(@Context UriInfo uriInfo, 
												@Context HttpHeaders httpHeaders,
												@Context SecurityContext securityContext) {
		
		String path = uriInfo.getAbsolutePath().toString();
		String queryParams = uriInfo.getQueryParameters().toString();
		
		String headers = httpHeaders.getRequestHeaders().toString();
		String cookies = httpHeaders.getCookies().toString();
		
		String authScheme = securityContext.getAuthenticationScheme();
		Boolean isOverHTTPS = securityContext.isSecure();
		
		return "Path \t: "+path + "\n\n"
				+ "Query Params : " + queryParams + "\n\n"
				+ "Headers : " + headers + "\n\n"
				+ "Cookies : " + cookies + "\n\n"
				+ "Authorization Scheme : " + authScheme + "\n\n"
				+ "Over HTTPS : " + isOverHTTPS;
	}
	
	public static class FilterBean {
		@MatrixParam("userName") 
		public String metrixParam;
		
		@HeaderParam("token")
		public String headerParam;
		
		@CookieParam("sessionId") 
		public String cookieParam;
	}
}


