package com.kodilla.library.service;

import com.kodilla.library.domain.Reader;
import com.kodilla.library.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbServiceReader {

    @Autowired
    ReaderRepository readerRepository;

    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }

    public Optional<Reader> getReader(Long id) {
        return readerRepository.findById(id);
    }

    public Reader saveReader(final Reader reader) {
        return readerRepository.save(reader);
    }

    public void deleteReader(final Long id) {
        readerRepository.deleteById(id);
    }
}