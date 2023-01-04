package ifpb.edu.br.streaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifpb.edu.br.streaming.mapper.MovieMapper;
import ifpb.edu.br.streaming.repository.MovieRepository;
import ifpb.edu.br.streaming.service.impl.MovieServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MovieController {
    
    private final MovieServiceImpl movieService;

    private final MovieMapper movieMapper;

    // @GetMapping("/all")
    // public ResponseEntity <?> getAllMovies () {

    //     List<Movie> movieList = movieService.
    // }
}
