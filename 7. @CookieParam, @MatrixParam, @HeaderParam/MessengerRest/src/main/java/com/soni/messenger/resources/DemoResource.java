package com.soni.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Produces(value=MediaType.TEXT_PLAIN)
@Consumes(value=MediaType.TEXT_PLAIN)
@Path(value="/demo")
public class DemoResource {

	@GET
	@Path(value="/demonstrate")
	public String test(
			@MatrixParam("userName") String metrixParam,
			@HeaderParam("token") String headerParam,
			@CookieParam("sessionId") String cookieParam) {
		return "Matrix Param  : " + metrixParam + "\nHeader Param : " + headerParam + "\nCookie Param : " + cookieParam;
	}
}
