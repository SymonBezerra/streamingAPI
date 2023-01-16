package ifpb.edu.br.streaming.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import ifpb.edu.br.streaming.domain.SeriesDetails;
import ifpb.edu.br.streaming.dto.SeriesDetailsDTO;

public class SeriesDetailsMapper {
    
    @Autowired
    private ModelMapper modelMapper;

    public SeriesDetailsDTO convertToDTO (SeriesDetails details) {
        SeriesDetailsDTO detailsDTO = modelMapper.map(details, SeriesDetailsDTO.class);
        return detailsDTO;
    }

    public SeriesDetails convertFromDTO (SeriesDetailsDTO detailsDTO) {
        SeriesDetails details = modelMapper.map(detailsDTO, SeriesDetails.class);
        return details;
    };
}
