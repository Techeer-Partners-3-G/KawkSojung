package com.example.Techeer_Partnerss;

import com.example.Techeer_Partnerss.dto.MovieDTO;
import com.example.Techeer_Partnerss.enums.Genre;
import com.example.Techeer_Partnerss.model.Movie;
import com.example.Techeer_Partnerss.repository.MovieRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public Movie updateMovie(Long movieId, MovieDTO updateMovieDTO, Genre genre){
        // 해당 ID로 영화를 찾음
        Movie movieToUpdate = movieRepository.findById(movieId)
                .orElseThrow(() -> new IllegalArgumentException("Movie not found"));

        // 업데이트할 정보가 있는 경우에만 업데이트 수행
        if (updateMovieDTO.getTitle() != null){
            movieToUpdate.setTitle(updateMovieDTO.getTitle());
        }
        if (updateMovieDTO.getReleaseDate() != null){
            movieToUpdate.setReleaseDate(updateMovieDTO.getReleaseDate());
        }
        if(updateMovieDTO.getEndDate() != null){
            movieToUpdate.setEndDate(updateMovieDTO.getEndDate());
            movieToUpdate.setShowing(movieToUpdate.getEndDate()!= null && movieToUpdate.getEndDate().isAfter(LocalDate.now()));
        }
        if(genre != null){
            movieToUpdate.setGenre(genre.toString());
        }

        return movieRepository.save(movieToUpdate);
    }

    // 상영 중인 영화를 반환하는 메서드
    public List<Movie> getShowingMovies() {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getEndDate() != null && movie.getEndDate().isAfter(LocalDate.now()))
                .collect(Collectors.toList());
    }


    public MovieDTO getMovieById(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Movie not found with id : " + id));

        MovieDTO movieDTO = new MovieDTO();

        movieDTO.setTitle(movie.getTitle());
        movieDTO.setReleaseDate(movie.getReleaseDate());
        movieDTO.setEndDate(movie.getEndDate());
        movieDTO.setGenre(Genre.valueOf(movie.getGenre()));

        return movieDTO;
    }



}
