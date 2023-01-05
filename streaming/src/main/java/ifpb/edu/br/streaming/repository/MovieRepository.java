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

    // @Query("SELECT * FROM MOVIES JOIN MOVIE_TAGS ON MOVIES.ID = MOVIE_TAGS.MOVIE_ID WHERE MOVIE_TAGS.TAGS IN :tags;")
    // public Optional<List<Movie>> findByTags (@Param("tags") List<String> tags);
}