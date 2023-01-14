package ifpb.edu.br.streaming.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ifpb.edu.br.streaming.domain.Series;

@Repository
public interface SeriesRepository extends JpaRepository <Series, Long> {
    
    public Optional<Series> findByName (String name);

    public Optional<List<Series>> findByCategory (String category);

    @Query("SELECT s FROM Series s JOIN s.tags t WHERE t IN (:tags)")
    public Optional<List<Series>> retrieveByTags (@Param List<String> tags);
}
