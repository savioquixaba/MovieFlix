package movieflix.controller;

import lombok.RequiredArgsConstructor;
import movieflix.controller.request.MovieRequest;
import movieflix.controller.response.MovieResponse;
import movieflix.entity.Movie;
import movieflix.mapper.MovieMapper;
import movieflix.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<MovieResponse> save(@RequestBody MovieRequest request){
        Movie savedMovie = movieService.save(MovieMapper.toMovie(request));
        return ResponseEntity.ok(MovieMapper.toMovieResponse(savedMovie));
    }

    @GetMapping
    public ResponseEntity<List<MovieResponse>> findAll(){
        return ResponseEntity.ok(movieService.findAll().stream()
                .map(movie -> MovieMapper.toMovieResponse(movie))
                .toList()
        );
    }
}
