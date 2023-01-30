package ifpb.edu.br.streaming.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SeriesDetailsDTO {
    
    // private Long id;
    private List<String> seriesCast;
    private int seasons;
    private String description;
    private String banner;
    @JsonIgnore
    private SeriesDTO series;
}
