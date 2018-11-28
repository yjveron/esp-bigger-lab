package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{
	public Movie findByName(String name);
}
