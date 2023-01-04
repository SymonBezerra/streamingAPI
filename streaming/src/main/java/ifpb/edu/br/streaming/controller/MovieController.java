package ifpb.edu.br.streaming.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ifpb.edu.br.streaming.domain.Movie;
import ifpb.edu.br.streaming.dto.ErrorDTO;
import ifpb.edu.br.streaming.dto.MovieDTO;
import ifpb.edu.br.streaming.exceptions.ContentNotFoundException;
import ifpb.edu.br.streaming.mapper.MovieMapper;
import ifpb.edu.br.streaming.service.impl.MovieServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MovieController {
    
    private final MovieServiceImpl movieService;

    private final MovieMapper movieMapper;

    @GetMapping("/all")
    public ResponseEntity <?> listAllMovies () {

        List<Movie> movieList = movieService.listAllMovies();
        List<MovieDTO> movieDTOList = new ArrayList<>();

        for (Movie movie : movieList) {
            movieDTOList.add(movieMapper.convertToDTO(movie));
        }

        return ResponseEntity.ok(movieDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity <?> listById (@PathVariable Long id) {
        try {
            Movie movie = movieService.findById(id);
            return ResponseEntity.ok(movieMapper.convertToDTO(movie));
        } catch (ContentNotFoundException ex) {
            return ResponseEntity.badRequest().body(new ErrorDTO(ex.getMessage()));
        }
    }

    @GetMapping("/name")
    public ResponseEntity <?> listByName (@RequestParam String name) {

        try {
            Movie movie = movieService.findByName(name);
            return ResponseEntity.ok(movieMapper.convertToDTO(movie));
        } catch (ContentNotFoundException ex) {
            return ResponseEntity.badRequest().body(new ErrorDTO(ex.getMessage()));
        }
    }

    

}
