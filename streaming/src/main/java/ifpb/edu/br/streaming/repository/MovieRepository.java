package ifpb.edu.br.streaming.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ifpb.edu.br.streaming.domain.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    
    public Movie getByName (String name);

    public List<Movie> getByCategory (String category);

    @Query("SELECT m FROM Movie m JOIN m.tags t WHERE t = LOWER(:tag)")
    public List<Movie> searchByTag (String tag);
}
