package ifpb.edu.br.streaming.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ifpb.edu.br.streaming.domain.Movie;
import ifpb.edu.br.streaming.dto.ErrorDTO;
import ifpb.edu.br.streaming.dto.MovieDTO;
import ifpb.edu.br.streaming.exceptions.ContentNotFoundException;
import ifpb.edu.br.streaming.exceptions.ExistingContentException;
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


    @GetMapping ("/search")
    public ResponseEntity<?> findByTags (@RequestParam List<String> tags) {
        try {
            List<Movie> movies = movieService.findByTags(tags);
            List<MovieDTO> moviesDTO = new ArrayList<>();

            for (Movie m : movies) {
                moviesDTO.add(movieMapper.convertToDTO(m));
            }
            return ResponseEntity.ok(moviesDTO);

        } catch (ContentNotFoundException ex) {
            return ResponseEntity.badRequest().body(new ErrorDTO(ex.getMessage()));
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createMovie (@RequestBody MovieDTO movieDTO) {
        
        try{
            movieService.createMovie(movieMapper.convertFromDTO(movieDTO));
            return ResponseEntity.ok(movieDTO);
        } catch (ExistingContentException ex) {
            return ResponseEntity.badRequest().body(new ErrorDTO(ex.getMessage()));
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity <?> updateMovie (@PathVariable Long id,@RequestBody MovieDTO movieDTO) {
        try {
            movieService.updateMovie(id, movieMapper.convertFromDTO(movieDTO));
            return ResponseEntity.ok(movieDTO);
        } catch (ExistingContentException | ContentNotFoundException ex) {
            return ResponseEntity.badRequest().body(new ErrorDTO(ex.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <?> deleteMovie (@PathVariable Long id) {
        try {
            movieService.deleteMovie(id);
            return ResponseEntity.noContent().build();
        } catch (ContentNotFoundException ex) {
            return ResponseEntity.badRequest().body(new ErrorDTO(ex.getMessage()));
        }
    }

}
