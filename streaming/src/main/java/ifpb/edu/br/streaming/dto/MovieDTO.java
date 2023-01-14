package ifpb.edu.br.streaming.dto;

import java.util.List;

import ifpb.edu.br.streaming.domain.MovieDetails;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieDTO {
    
    private String name;
    private String category;
    private List<String> tags;
    private MovieDetails details;
}
