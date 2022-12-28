package ifpb.edu.br.streaming.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import ifpb.edu.br.streaming.domain.Movie;
import ifpb.edu.br.streaming.dto.MovieDTO;

public class MovieMapper {
    
    @Autowired
    private ModelMapper modelMapper;

    public MovieDTO convertToDTO (Movie movie) {
        MovieDTO movieDTO = modelMapper.map(movie, MovieDTO.class);

        return movieDTO;
    }

    public Movie convertFromDTO (MovieDTO movieDTO) {
        Movie movie = modelMapper.map(movieDTO, Movie.class);

        return movie;
    }
}
