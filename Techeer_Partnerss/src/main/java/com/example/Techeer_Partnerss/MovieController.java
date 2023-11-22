package com.example.Techeer_Partnerss;

import com.example.Techeer_Partnerss.dto.MovieDTO;
import com.example.Techeer_Partnerss.model.Movie;
import com.example.Techeer_Partnerss.enums.Genre;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    @Operation(summary = "새 영화 등록", description = "새 영화를 등록하기 위한 상세 정보")
    public ResponseEntity<Movie> createMovie(
            @Parameter(description = "장르를 포함한 영화 정보", required = true) @RequestBody MovieDTO movieDTO) {

        Movie movie = movieService.createMovie(movieDTO.getGenre(), movieDTO);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

}