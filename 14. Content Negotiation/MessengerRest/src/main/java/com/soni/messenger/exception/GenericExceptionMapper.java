package com.soni.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author suyash
 * If there is no such exception mapper available that can map the underlying exception.
 * Then this exception mapper will come into play.
 * It's a generic exception mapper which can map to any exception.
 */
@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable ex) {
		ErrorPage errorPage = new ErrorPage(ex.getMessage(), Status.INTERNAL_SERVER_ERROR.getStatusCode());
		Response response = Response
													.status(Status.INTERNAL_SERVER_ERROR)
													.entity(errorPage)
													.build();
		return response;
	}

}
