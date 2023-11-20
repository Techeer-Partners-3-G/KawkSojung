package com.example.Techeer_Partnerss;

import com.example.Techeer_Partnerss.dto.MovieDTO;
import com.example.Techeer_Partnerss.enums.Genre;
import com.example.Techeer_Partnerss.model.Movie;
import com.example.Techeer_Partnerss.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie createMovie(Genre genre, MovieDTO movieDTO) {
        if (movieDTO.getTitle() == null) {
            throw new IllegalArgumentException("Title cannot be null");
        }

        Movie movie = new Movie();
        movie.setTitle(movieDTO.getTitle());
        movie.setGenre(genre.toString());
        movie.setReleaseDate(movieDTO.getReleaseDate());
        movie.setEndDate(movieDTO.getEndDate());
        movie.setShowing(movie.getEndDate() != null && movie.getEndDate().isAfter(LocalDate.now()));

        return movieRepository.save(movie);
    }

    // 상영 중인 영화를 반환하는 메서드
    public List<Movie> getShowingMovies() {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getEndDate() != null && movie.getEndDate().isAfter(LocalDate.now()))
                .collect(Collectors.toList());
    }
}
