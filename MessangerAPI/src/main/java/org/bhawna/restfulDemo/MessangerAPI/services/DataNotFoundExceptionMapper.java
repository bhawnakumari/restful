package org.bhawna.restfulDemo.MessangerAPI.services;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.bhawna.restfulDemo.MessangerAPI.Model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException ex) {
		ErrorMessage errorMsg = new ErrorMessage(ex.getMessage(), 404);
		return Response.status(Status.NOT_FOUND).entity(errorMsg).build();
	}

}
