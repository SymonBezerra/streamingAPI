package ifpb.edu.br.streaming.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieDetailsDTO {
    
    private List<String> movieCast;
    private int duration;
    private String description;
    private String banner;
    @JsonIgnore
    private MovieDTO movie;
}
