package com.webservice.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class BadRequestException extends WebApplicationException {

	private static final long serialVersionUID = 1L;

	public BadRequestException(Object reponse, MediaType mediaType){
		super(Response.status(Status.BAD_REQUEST).entity(reponse).type(mediaType).build());
	}
}
