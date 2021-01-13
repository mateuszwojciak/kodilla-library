package com.kodilla.library.controller;

import com.kodilla.library.domain.ReaderDto;
import com.kodilla.library.mapper.ReaderMapper;
import com.kodilla.library.service.DbServiceReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/reader")
public class ReaderController {

    @Autowired
    private DbServiceReader dbServiceReader;

    @Autowired
    private ReaderMapper readerMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getReaders")
    public List<ReaderDto> getReaders() {
        return readerMapper.mapToReaderDtoList(dbServiceReader.getAllReaders());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getReader")
    public ReaderDto getReader(@RequestParam Long readerId) throws BookNotFoundException {
        return readerMapper.mapToReaderDto(dbServiceReader.getReader(readerId).orElseThrow(BookNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteReader")
    public void deleteReader(@RequestParam Long readerId) {
        dbServiceReader.deleteReader(readerId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateReader")
    public ReaderDto updateReader(@RequestBody ReaderDto readerDto) {
        return readerMapper.mapToReaderDto(dbServiceReader.saveReader(readerMapper.mapToReader(readerDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createReader", consumes = APPLICATION_JSON_VALUE)
    public void createReader(@RequestBody ReaderDto readerDto) {
        dbServiceReader.saveReader(readerMapper.mapToReader(readerDto));
    }
}
