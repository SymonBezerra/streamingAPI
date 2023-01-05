package ifpb.edu.br.streaming.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ifpb.edu.br.streaming.domain.Movie;
import ifpb.edu.br.streaming.exceptions.ContentNotFoundException;
import ifpb.edu.br.streaming.exceptions.ExistingContentException;

@Service
public interface MovieService {

    // CREATE
    public Movie createMovie (Movie movie) throws ExistingContentException;

    // READ

    public List<Movie> listAllMovies ();

    public Movie findById (Long id) throws ContentNotFoundException;

    public Movie findByName (String name) throws ContentNotFoundException;
    
    public List<Movie> findByCategory (String category) throws ContentNotFoundException;
    
    public List<Movie> findByTags (List<String> tag) throws ContentNotFoundException;

    // UPDATE 

        // PUT
    public Movie updateMovie (Long id, Movie movie) throws ContentNotFoundException, ExistingContentException;

        // PATCH
    public Movie updateTags (Long id, List<String> tags) throws ContentNotFoundException;

    // DELETE

    public void deleteMovie (Long id) throws ContentNotFoundException;
    
}
