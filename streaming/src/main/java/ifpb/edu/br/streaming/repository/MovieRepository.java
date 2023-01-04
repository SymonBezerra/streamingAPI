package ifpb.edu.br.streaming.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifpb.edu.br.streaming.domain.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    
    public Optional<Movie> findByName (String name);

    public Optional<List<Movie>> findByCategory (String category);

//     @Query("SELECT m FROM movies m JOIN movie_tags t WHERE t = LOWER(:tag)")
//     public Optional<List<Movie>> findByTags (@Param("tag") String tag);
}