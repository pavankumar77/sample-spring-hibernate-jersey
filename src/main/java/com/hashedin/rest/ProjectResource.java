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

import com.hashedin.model.Project;
import com.hashedin.service.ProjectServices;

@Component
@Path("/Projects")
public class ProjectResource {

	@Autowired
	private ProjectServices ProjectServices;

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Project> list() {
		return ProjectServices.getAllProject();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/{Id}")
	public Project get(@PathParam("Id") int Id) {
		return ProjectServices.findProject(Id);
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response create(Project Project,	@Context final HttpServletResponse response)
			throws URISyntaxException {
		ProjectServices.createProject(Project);
		response.setStatus(Response.Status.CREATED.getStatusCode());
		return Response.created(new URI("/Projects/" + Project.getId()))
				.build();
	}

}
