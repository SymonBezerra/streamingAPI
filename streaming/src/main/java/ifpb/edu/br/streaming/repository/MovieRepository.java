package ifpb.edu.br.streaming.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ifpb.edu.br.streaming.domain.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    
    public Optional<Movie> findByName (String name);

    public Optional<List<Movie>> findByCategory (String category);

    // @Query("SELECT m FROM movies m INNER JOIN movie_tags t ON m.id = t.movie_id WHERE m.id = X")
    // public Optional<List<Movie>> findByTags (@Param("tag") String tag);
}