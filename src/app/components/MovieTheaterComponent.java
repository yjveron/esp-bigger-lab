package app.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Movie;
import app.entity.MovieTheater;
import app.repositories.MovieRepository;
import app.repositories.MovieTheaterRepository;

@Component
public class MovieTheaterComponent {
	
	@Autowired
	MovieTheaterRepository repo;
	
	@Autowired
	MovieRepository movre;
	
//	public MovieTheater getTicketSum(int total) {
//	// Search specific timeslot, then check how many tickets
//	return null;
//}
	
	public int buyTicket(String theater, String movie, String timeSlot) {
		//search movie id somehow
		
		Movie m = movre.findByName(movie);
		
		if (m != null) {
			MovieTheater t = repo.findByTheaterNameAndTimeSlotAndMovieId(theater, timeSlot, m.getId());
			
			int b = t.getSeatCount();
			int c = b - 1;
			t.setSeatCount(c);
			repo.save(t);
			return t.getSeatCount();
		}
		else {
			return 0;
		}
	}
	
	public List<MovieTheater> getTheaters(String name, String time){
		return repo.findByTheaterNameAndTimeSlot(name, time);
	}
}
