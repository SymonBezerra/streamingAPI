package ifpb.edu.br.streaming.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import ifpb.edu.br.streaming.domain.MovieDetails;
import ifpb.edu.br.streaming.dto.MovieDetailsDTO;

public class MovieDetailsMapper {

    @Autowired
    private ModelMapper modelMapper;

    public MovieDetailsDTO convertToDTO (MovieDetails details) {
        MovieDetailsDTO detailsDTO = modelMapper.map(details, MovieDetailsDTO.class);
        return detailsDTO;
    }

    public MovieDetails convertFromDTO (MovieDetailsDTO detailsDTO) {
        MovieDetails details = modelMapper.map(detailsDTO, MovieDetails.class);
        return details;
    }
    
}
