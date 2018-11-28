package app.rest;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.components.MovieComponent;
import app.components.MovieTheaterComponent;
import app.entity.Movie;
import app.entity.MovieTheater;
import app.repositories.MovieRepository;
import app.repositories.MovieTheaterRepository;

@Component
@Path("/movieTheater")
public class MovieTheaterController {
	
	
	//MOVIE
	@Autowired
	Movie movie;
	
	@Autowired
	MovieComponent movieService;
	
	@Autowired
	MovieRepository movieRepo;
	
	//THEATERge
	
	@Autowired
	MovieTheater theater;
	
	@Autowired
	MovieTheaterComponent theaterService;
	
	@Autowired
	MovieTheaterRepository theaterRepo;
	
	@GET
	@Path("/getTicketSum")
	@Produces(MediaType.APPLICATION_JSON)
	public int getSeatCount(@QueryParam("name") String name,
							@QueryParam("time") String time) throws IOException{
		return theaterRepo.findByTheaterNameAndTimeSlot(name, time).get(0).getSeatCount();
		
		//di ko maget bakit kailangan yung .get(0) before .getSeatCount()
	}
	
	@POST
	@Path("/buyTicket")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public int buyTicket(@FormParam("theater") String theater,
						 @FormParam("movie") String movie,
						 @FormParam("timeslot") String timeslot) throws IOException{
		return theaterService.buyTicket(theater, movie, timeslot);
	}
	
	//FOR TESTING ONLY
	@GET
	@Path("/findTheater")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MovieTheater> getTheater(@QueryParam("name") String name,
									     @QueryParam("time") String time) throws IOException{
		return theaterRepo.findByTheaterNameAndTimeSlot(name, time);
	}
}
