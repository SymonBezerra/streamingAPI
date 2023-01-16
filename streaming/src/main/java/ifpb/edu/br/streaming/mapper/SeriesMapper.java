package ifpb.edu.br.streaming.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import ifpb.edu.br.streaming.domain.Series;
import ifpb.edu.br.streaming.domain.SeriesDetails;
import ifpb.edu.br.streaming.dto.SeriesDTO;
import ifpb.edu.br.streaming.dto.SeriesDetailsDTO;

public class SeriesMapper {
    
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SeriesDetailsMapper detailsMapper;

    public SeriesDTO convertToDTO (Series series) {
        SeriesDTO seriesDTO = modelMapper.map(series, SeriesDTO.class);
        SeriesDetailsDTO detailsDTO = detailsMapper.convertToDTO(series.getDetails());
        seriesDTO.setDetails(detailsDTO);
        return seriesDTO;
    }

    public Series convertFromDTO (SeriesDTO seriesDTO) {
        Series series = modelMapper.map(seriesDTO, Series.class);
        SeriesDetails details = detailsMapper.convertFromDTO(seriesDTO.getDetails());
        series.setDetails(details);
        return series;
    }

}
