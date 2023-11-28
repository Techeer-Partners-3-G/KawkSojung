package com.example.Techeer_Partnerss;

import com.example.Techeer_Partnerss.dto.MovieDTO;
import com.example.Techeer_Partnerss.model.Movie;
import com.example.Techeer_Partnerss.enums.Genre;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

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

    @GetMapping("/{id}")
    @Operation(summary = "단일 영화 조회", description = "단일 영화 조회하기 위한 상세 정보")
    public ResponseEntity<MovieDTO> getMovieById(
            @Parameter(description = "조회할 영화의 ID", required = true) @PathVariable Long id) {

        try {
            MovieDTO movieDTO = movieService.getMovieById(id);
            return ResponseEntity.ok(movieDTO);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    @Operation(summary = "영화 목록 조회", description = "전체 영화 목록을 조회하거나, 장르나 상영 여부 조건으로 필터링하여 조회")
    public ResponseEntity<List<MovieDTO>>getMovies(
            @Parameter(description = "필터링할 장르") @RequestParam(required = false) Genre genre,
            @Parameter(description = "현재 상영중인 영화만 조회할 지 여부") @RequestParam(required = false) Boolean isShowing) {

        List<MovieDTO> movies = movieService.getMovies(genre, isShowing);
        return ResponseEntity.ok(movies);
    }

}
