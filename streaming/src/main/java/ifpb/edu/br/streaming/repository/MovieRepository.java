package ifpb.edu.br.streaming.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ifpb.edu.br.streaming.domain.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    
    public Optional<Movie> findByName (String name);

    public Optional<List<Movie>> findByCategory (String category);

    @Query("SELECT m FROM Movie m JOIN m.tags t WHERE t IN (:tags)")
    public Optional<List<Movie>> retrieveByTags (@Param("tags") List<String> tags);
}