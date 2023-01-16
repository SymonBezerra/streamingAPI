package ifpb.edu.br.streaming.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SeriesDetailsDTO {
    
    private List<String> seriesCast;
    private int seasons;
    private String description;
}
