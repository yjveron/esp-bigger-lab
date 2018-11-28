package app.components;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Movie;
import app.entity.MovieTheater;
import app.repositories.MovieRepository;
import app.repositories.MovieTheaterRepository;

@Component
public class DataSeeder {

	@Autowired
	MovieRepository movierepo;
	
	@Autowired
	MovieTheaterRepository theaterrepo;
	
	@PostConstruct
	public void init() {
		if (movierepo.count() == 0) {
			Movie m = makeMovie("Spider-man", 8);
			movierepo.save(m);
			
			m = makeMovie("Venom", 7);
			movierepo.save(m);
			
			m = makeMovie("Up", 10);
			movierepo.save(m);
		}
		
		if (theaterrepo.count() == 0) {
			
			MovieTheater t = makeTheater((long) 8, "Cinema 1", 20, "5:30");
			theaterrepo.save(t);
			
			t = makeTheater((long) 8, "Cinema 1", 20, "8:00");
			theaterrepo.save(t);
			
			t = makeTheater((long) 8, "Cinema 1", 20, "3:00");
			theaterrepo.save(t);
			
			t = makeTheater((long) 7, "Cinema 2", 20, "5:30");
			theaterrepo.save(t);
			
			t = makeTheater((long) 7, "Cinema 2", 20, "8:00");
			theaterrepo.save(t);
			
			t = makeTheater((long) 7, "Cinema 2", 20, "3:00");
			theaterrepo.save(t);
			
			t = makeTheater((long) 10, "Cinema 3", 20, "5:30");
			theaterrepo.save(t);
			
			t = makeTheater((long) 10, "Cinema 3", 20, "8:00");
			theaterrepo.save(t);
			
			t = makeTheater((long) 10, "Cinema 3", 20, "3:00");
			theaterrepo.save(t);
		}
	}
	
	private Movie makeMovie(String name, int rating) {
		Movie m = new Movie();
		m.setName(name);
		m.setRating(rating);
		
		return m;
	}
	
	private MovieTheater makeTheater(Long movieID, String theaterName, int seatCount, String timeSlot) {
		MovieTheater t = new MovieTheater();
		t.setMovieId(movieID);
		t.setTheaterName(theaterName);
		t.setSeatCount(seatCount);
		t.setTimeSlot(timeSlot);
		
		return t;
	}
}
