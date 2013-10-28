package com.webservice.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.webservice.error.CustomError;
import com.webservice.exception.BadRequestException;
import com.webservice.provider.Header;

@Component
@Path("/test")
public class TestService {
	@GET
	@Path("/provider")
	public String testProvider(@Context Header header){
		if(header.getUsername() == null || header.getPassword() == null){
			throw new BadRequestException(new CustomError("E0001", "Bad User"), MediaType.APPLICATION_JSON_TYPE);
		}else{
			// do authentication change something
		}
		return "Success";
	}
}
