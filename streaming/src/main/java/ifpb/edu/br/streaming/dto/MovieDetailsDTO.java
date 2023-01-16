package ifpb.edu.br.streaming.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieDetailsDTO {
    
    private List<String> movieCast;
    private int duration;
    private String description;
}
