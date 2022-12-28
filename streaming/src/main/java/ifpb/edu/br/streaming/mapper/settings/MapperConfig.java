package ifpb.edu.br.streaming.mapper.settings;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ifpb.edu.br.streaming.mapper.MovieMapper;

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
}
