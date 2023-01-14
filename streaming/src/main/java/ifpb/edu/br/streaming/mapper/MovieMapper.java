package ifpb.edu.br.streaming.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import ifpb.edu.br.streaming.domain.Movie;
import ifpb.edu.br.streaming.dto.MovieDTO;
import ifpb.edu.br.streaming.dto.MovieDetailsDTO;

public class MovieMapper {
    
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MovieDetailsMapper detailsMapper;

    public MovieDTO convertToDTO (Movie movie) {
        MovieDTO movieDTO = modelMapper.map(movie, MovieDTO.class);
        MovieDetailsDTO detailsDTO = detailsMapper.convertToDTO(movie.getDetails());
        movieDTO.setDetails(detailsDTO);
        return movieDTO;
    }

    public Movie convertFromDTO (MovieDTO movieDTO) {
        Movie movie = modelMapper.map(movieDTO, Movie.class);

        return movie;
    }
}
