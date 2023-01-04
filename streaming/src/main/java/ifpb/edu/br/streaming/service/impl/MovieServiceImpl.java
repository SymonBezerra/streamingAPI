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

    @Override
    public Movie findById(Long id) throws ContentNotFoundException {
        if (!movieRepository.findById(id).isPresent()) {
            throw new ContentNotFoundException("Não existe um filme com este ID na plataforma!");
        }

        return movieRepository.findById(id).get();
    }

    @Override
    public Movie findByName(String name) throws ContentNotFoundException {
        if (!movieRepository.findByName(name).isPresent()) {
            throw new ContentNotFoundException("Não existe um filme com este nome na plataforma!");
        }

        return movieRepository.findByName(name).get();
    }

    @Override
    public List<Movie> findByCategory(String category) throws ContentNotFoundException {
        List<Movie> movies = movieRepository.findByCategory(category).get();
        if (movies.isEmpty()) {
            throw new ContentNotFoundException ("Não há nenhum filme desta categoria na plataforma!");
        }

        return movies;
    }

    @Override
    public Movie searchByTag(String tag) throws ContentNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Movie updateMovie(Long id, Movie movie) throws ContentNotFoundException, ExistingContentException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Movie updateTags(Long id, List<String> tags) throws ContentNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteMovie(Long id) throws ContentNotFoundException {
        // TODO Auto-generated method stub
        
    }
    
}
