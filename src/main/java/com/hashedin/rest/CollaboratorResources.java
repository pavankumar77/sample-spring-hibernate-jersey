package com.hashedin.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hashedin.model.Collaborators;
import com.hashedin.repository.CollaboratorRepositaryImpl;


@Component
@Path("/Collaborators")


public class CollaboratorResources {


	@Autowired
	private CollaboratorRepositaryImpl CollaboratorRepositarys;

	

	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response create(Collaborators Collaborator,	@Context final HttpServletResponse response)
			throws URISyntaxException {
		CollaboratorRepositarys.createCollaborator(Collaborator);
		response.setStatus(Response.Status.CREATED.getStatusCode());
		return Response.created(new URI("/Collaborators/" + Collaborator.getCollaboratorId()))
				.build();
	}
}
