package ifpb.edu.br.streaming.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieDTO {

    // private Long id;
    private String name;
    private String category;
    private List<String> tags;
    private MovieDetailsDTO details;
}
