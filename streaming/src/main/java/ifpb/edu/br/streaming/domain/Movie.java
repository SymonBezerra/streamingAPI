package ifpb.edu.br.streaming.domain;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
// CREATE TABLE movies (id INTEGER PRIMARY KEY AUTOINCREMENT,
// name TEXT)
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String category;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> tags;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "details_id", referencedColumnName = "id")
    @JsonManagedReference
    private MovieDetails details;

}
