package ifpb.edu.br.streaming.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ifpb.edu.br.streaming.domain.Series;
import ifpb.edu.br.streaming.exceptions.ContentNotFoundException;
import ifpb.edu.br.streaming.exceptions.ExistingContentException;

@Service
public interface SeriesService {
    
    // CREATE 
    public Series createSeries (Series series) throws ExistingContentException;

    // READ

    public List<Series> listAllSeries ();

    public Series findById (Long id) throws ContentNotFoundException;

    public List<Series> findByTags (List<String> tags) throws ContentNotFoundException;

    // PUT

    public Series updateSeries (Long id, Series series) throws ContentNotFoundException, ExistingContentException;

    // PATCH

    public Series updateTags (Long id, List<String> tags) throws ContentNotFoundException;

    // DELETE

    public void deleteSeries (Long id) throws ContentNotFoundException;
}
