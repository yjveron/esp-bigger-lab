package app.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Movie;
import app.repositories.MovieRepository;

@Component
public class MovieComponent {
	@Autowired
	MovieRepository repo;
	
	public Movie getMovie(String name) {
		//return repo.findByName(name);
		//Print movie
		
		return null;
	}
}
