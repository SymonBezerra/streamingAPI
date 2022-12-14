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

    // PUT

    public Series updateSeries (Long id, Series series) throws ContentNotFoundException, ExistingContentException;

    // DELETE

    public void deleteSeries (Long id) throws ContentNotFoundException;
}
