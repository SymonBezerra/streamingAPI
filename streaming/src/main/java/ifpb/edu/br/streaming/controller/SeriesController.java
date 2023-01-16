package ifpb.edu.br.streaming.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ifpb.edu.br.streaming.domain.Series;
import ifpb.edu.br.streaming.dto.ErrorDTO;
import ifpb.edu.br.streaming.dto.SeriesDTO;
import ifpb.edu.br.streaming.exceptions.ContentNotFoundException;
import ifpb.edu.br.streaming.exceptions.ExistingContentException;
import ifpb.edu.br.streaming.mapper.SeriesMapper;
import ifpb.edu.br.streaming.service.impl.SeriesServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/series")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SeriesController {
    
    private final SeriesServiceImpl seriesService;

    private final SeriesMapper seriesMapper;

    @GetMapping("/all")
    public ResponseEntity<?> listAllSeries () {
        List<Series> seriesList = seriesService.listAllSeries();
        List<SeriesDTO> seriesDTOList = new ArrayList<>();

        for (Series s : seriesList) {
            seriesDTOList.add(seriesMapper.convertToDTO(s));
        }

        return ResponseEntity.ok(seriesDTOList);   
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listById (@PathVariable Long id) {
        try {
            Series series = seriesService.findById(id);
            return ResponseEntity.ok(seriesMapper.convertToDTO(series));
        } catch (ContentNotFoundException ex) {
            return ResponseEntity.badRequest().body(new ErrorDTO(ex.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<?> listByTags (@RequestParam List<String> tags) {
        try {
            List<Series> seriesList = seriesService.findByTags(tags);
            List<SeriesDTO> seriesDTOList = new ArrayList<>();

            for (Series s : seriesList) {
                seriesDTOList.add(seriesMapper.convertToDTO(s));
            }

            return ResponseEntity.ok(seriesDTOList);
        } catch (ContentNotFoundException ex) {
            return ResponseEntity.badRequest().body(new ErrorDTO(ex.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<?> createSeries (@RequestBody SeriesDTO seriesDTO) {
        try {
            Series seriesToCreate = seriesMapper.convertFromDTO(seriesDTO);
            seriesService.createSeries(seriesToCreate);
            return ResponseEntity.ok(seriesDTO);
        } catch (ExistingContentException ex) {
            return ResponseEntity.badRequest().body(new ErrorDTO(ex.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSeries (@PathVariable Long id,@RequestBody SeriesDTO seriesDTO) {
        try {
            seriesService.updateSeries(id, seriesMapper.convertFromDTO(seriesDTO));
            return ResponseEntity.ok(seriesDTO);
        } catch (ContentNotFoundException | ExistingContentException ex) {
            return ResponseEntity.badRequest().body(new ErrorDTO(ex.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSeries (@PathVariable Long id) {
        try {
            seriesService.deleteSeries(id);
            return ResponseEntity.noContent().build();
        } catch (ContentNotFoundException ex) {
            return ResponseEntity.badRequest().body(new ErrorDTO(ex.getMessage()));
        }
    }
}
