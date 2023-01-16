package ifpb.edu.br.streaming.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import ifpb.edu.br.streaming.domain.Series;
import ifpb.edu.br.streaming.dto.SeriesDTO;

public class SeriesMapper {
    
    @Autowired
    private ModelMapper modelMapper;

    public SeriesDTO convertToDTO (Series series) {
        SeriesDTO seriesDTO = modelMapper.map(series, SeriesDTO.class);
        return seriesDTO;
    }

    public Series convertFromDTO (SeriesDTO seriesDTO) {
        Series series = modelMapper.map(seriesDTO, Series.class);
        return series;
    }

}
