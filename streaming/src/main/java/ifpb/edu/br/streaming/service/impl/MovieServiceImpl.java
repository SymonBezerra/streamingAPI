package ifpb.edu.br.streaming.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifpb.edu.br.streaming.domain.Movie;
import ifpb.edu.br.streaming.exceptions.ContentNotFoundException;
import ifpb.edu.br.streaming.exceptions.ExistingContentException;
import ifpb.edu.br.streaming.repository.MovieRepository;
import ifpb.edu.br.streaming.service.MovieService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MovieServiceImpl implements MovieService {
    
    private final MovieRepository movieRepository;

    @Override
    public Movie createMovie(Movie movie) throws ExistingContentException {
        if (movieRepository.findByName(movie.getName()).isPresent()) {
            throw new ExistingContentException ("Já existe um filme cadastrado com este nome");
        }
        
        return movieRepository.save(movie);
    }

    public List<Movie> listAllMovies () {

        return movieRepository.findAll();
        
    }

    @Override
    public Movie findById(Long id) throws ContentNotFoundException {
        if (!movieRepository.findById(id).isPresent()) {
            throw new ContentNotFoundException("Não existe um filme com este ID na plataforma!");
        }

        return movieRepository.findById(id).get();
    }

    @Override
    public List<Movie> findByTags(List<String> tags) throws ContentNotFoundException {
        List<Movie> movies = movieRepository.retrieveByTags(tags).get();

        if (movies.isEmpty()) {
            throw new ContentNotFoundException ("Não temos este conteúdo cadastrado na plataforma!");
        }
        return movies;
    }

    @Override
    public Movie updateMovie(Long id, Movie movie) throws ContentNotFoundException, ExistingContentException {
        if (!movieRepository.findById(id).isPresent()) {
            throw new ContentNotFoundException("Não há nenhum filme com este ID na nossa plataforma!");   
        }
        if (movieRepository.findByName(movie.getName()).isPresent()) {
            throw new ExistingContentException("Já existe um filme com este dados na nossa plataforma!");
        }

        movie.setId(id);
        return movieRepository.save(movie);
    }


    @Override
    public Movie updateTags(Long id, List<String> tags) throws ContentNotFoundException {
        
        if (!movieRepository.findById(id).isPresent()) {
            throw new ContentNotFoundException("Não há nenhum filme com este ID na nossa plataforma!");
        }
        Movie movieToPatch = movieRepository.findById(id).get();

        movieToPatch.setTags(tags);
        movieRepository.save(movieToPatch);

        return movieToPatch;

    }

    @Override
    public void deleteMovie(Long id) throws ContentNotFoundException {
        if (!movieRepository.findById(id).isPresent()) {
            throw new ContentNotFoundException("Não há nenhum filme com este ID na nossa plataforma!");   
        } 
        
        Movie movieToDelete = movieRepository.findById(id).get();
        movieRepository.delete(movieToDelete);
    }
    
}
