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

    //수정하는 메서드
    @PutMapping("/{id}")
    @Operation(summary = "영화 정보 수정", description = "기존 영화 정보 수정.")
    public ResponseEntity<Movie> updateMovie( @Parameter(description = "수정할 영화의 ID", required = true) @PathVariable Long id,
                                              @Parameter(description = "업데이트할 영화 정보", required = true) @RequestBody MovieDTO updateMovieDTO,
                                              @Parameter(description = "장르 정보", required = true) @RequestParam(required = false) Genre genre){
        Movie updatedMovie = movieService.updateMovie(id, updateMovieDTO,genre);
        if(updatedMovie != null){
            return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
