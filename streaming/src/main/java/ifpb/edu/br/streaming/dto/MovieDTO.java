package ifpb.edu.br.streaming.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private String name;
    private String category;
    private List<String> tags;
    private MovieDetailsDTO details;
}
