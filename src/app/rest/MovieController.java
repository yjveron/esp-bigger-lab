package app.rest;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.components.MovieComponent;
import app.entity.Movie;

// THIS IS THE SERVICE CLASS
@Component
@Path("/movie")
public class MovieController {

	@Autowired
	MovieComponent service;
	
	@GET
	@Path("/getMovie")
	@Produces(MediaType.APPLICATION_JSON)
	public Movie getMovie(@QueryParam("name") String name) throws IOException {
		return service.getMovie(name);
	}
	
}
