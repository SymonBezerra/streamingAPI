package ifpb.edu.br.streaming.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifpb.edu.br.streaming.domain.Series;
import ifpb.edu.br.streaming.exceptions.ContentNotFoundException;
import ifpb.edu.br.streaming.exceptions.ExistingContentException;
import ifpb.edu.br.streaming.repository.SeriesRepository;
import ifpb.edu.br.streaming.service.SeriesService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SeriesServiceImpl implements SeriesService {

    private final SeriesRepository seriesRepository;
    @Override
    public Series createSeries(Series series) throws ExistingContentException {
        if (!seriesRepository.findByName(series.getName()).isPresent()) {
            return seriesRepository.save(series);
        }
        throw new ExistingContentException("Este conteúdo já está cadastrado na nossa plataforma!");
    }

    @Override
    public List<Series> listAllSeries() {
        return seriesRepository.findAll();
    }

    @Override
    public List<Series> findByTags(List<String> tags) throws ContentNotFoundException {
        List<Series> series = seriesRepository.retrieveByTags(tags).get();
        if (series.isEmpty()) {
            throw new ContentNotFoundException ("Não temos este conteúdo cadastrado em nossa plataforma!");
        }

        return series;
    }

    @Override
    public Series findById(Long id) throws ContentNotFoundException {
        if (seriesRepository.findById(id).isPresent()) {
            return seriesRepository.findById(id).get();
        }
        throw new ContentNotFoundException ("Este conteúdo não está cadastrado na nossa plataforma!");
    }

    @Override
    public Series updateSeries(Long id, Series series) throws ContentNotFoundException, ExistingContentException {
        if (!seriesRepository.findById(id).isPresent()) {
            throw new ContentNotFoundException("Este conteúdo não está cadastrado na nossa plataforma!");
        } else if (seriesRepository.findByName(series.getName()).isPresent()) {
            throw new ExistingContentException("Já existe um conteúdo cadastrado com este nome na plataforma!");
        }
        series.setId(id);
        return seriesRepository.save(series);
    }

    @Override
    public void deleteSeries(Long id) throws ContentNotFoundException {
        if (!seriesRepository.findById(id).isPresent()) {
            throw new ContentNotFoundException("Este conteúdo não está cadastrado na nossa plataforma!");
        }
        Series seriesToDelete = seriesRepository.findById(id).get();
        seriesRepository.delete(seriesToDelete);
         
    }
    
}
