package com.soni.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {
		ErrorPage errorPage = new ErrorPage(ex.getMessage(), Status.NOT_FOUND.getStatusCode());
		Response response = Response
													.status(Status.NOT_FOUND)
													.entity(errorPage)
													.build();
		return response;
	}

}
