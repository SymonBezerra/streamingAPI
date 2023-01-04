package ifpb.edu.br.streaming.service.impl;

import java.util.List;

import ifpb.edu.br.streaming.domain.Movie;
import ifpb.edu.br.streaming.exceptions.ContentNotFoundException;
import ifpb.edu.br.streaming.exceptions.ExistingContentException;
import ifpb.edu.br.streaming.service.MovieService;

public class MovieServiceImpl implements MovieService {

    @Override
    public Movie createMovie(Movie movie) throws ExistingContentException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Movie findById(Long id) throws ContentNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Movie findByName(String name) throws ContentNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Movie> findByCategory(String category) throws ContentNotFoundException {
        // TODO Auto-generated method stub
        return null;
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
