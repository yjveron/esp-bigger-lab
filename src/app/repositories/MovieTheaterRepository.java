package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.MovieTheater;

@Repository
public interface MovieTheaterRepository extends JpaRepository<MovieTheater, Long>{
	List<MovieTheater> findByTheaterNameAndTimeSlot(String name, String time);
	MovieTheater findByTheaterNameAndTimeSlotAndMovieId(String name, String time, Long movieId);
	
//	public MovieTheater findBymovieId(Long movieId);
//	public MovieTheater findBytheaterName(String theaterName);
//	public MovieTheater findBytimeSlot(String timeSlot);
}
