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

    @Query("SELECT * FROM movies m JOIN movie_tags mt ON m.id = mt.movie_id WHERE mt.tags IN (:tags);")
    public Optional<List<Movie>> findByTags (@Param("tags") List<String> tags);
}