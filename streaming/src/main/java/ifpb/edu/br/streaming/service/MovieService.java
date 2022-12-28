package ifpb.edu.br.streaming.service;

import org.springframework.stereotype.Service;

import ifpb.edu.br.streaming.domain.Movie;
import ifpb.edu.br.streaming.exceptions.ContentNotFoundException;
import ifpb.edu.br.streaming.exceptions.ExistingContentException;

@Service
public interface MovieService {

    // CREATE
    public Movie createMovie (Movie movie) throws ExistingContentException;

    // READ
    public Movie findById (Long id) throws ContentNotFoundException;
    
}
