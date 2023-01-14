package ifpb.edu.br.streaming.mapper.settings;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ifpb.edu.br.streaming.mapper.MovieDetailsMapper;
import ifpb.edu.br.streaming.mapper.MovieMapper;
import ifpb.edu.br.streaming.mapper.SeriesDetailsMapper;
import ifpb.edu.br.streaming.mapper.SeriesMapper;

@Configuration
public class MapperConfig {
    
    @Bean
    public ModelMapper modelMapper () {
        return new ModelMapper();
    }

    @Bean
    public MovieMapper movieMapper () {
        return new MovieMapper();
    }

    @Bean
    public SeriesMapper seriesMapper () {
        return new SeriesMapper();
    }

    @Bean
    public MovieDetailsMapper movieDetailsMapper () {
        return new MovieDetailsMapper();
    }

    @Bean
    public SeriesDetailsMapper seriesDetailsMapper () {
        return new SeriesDetailsMapper();
    }
}
