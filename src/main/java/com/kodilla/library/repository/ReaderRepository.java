package com.kodilla.library.repository;

import com.kodilla.library.domain.Reader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface ReaderRepository extends CrudRepository<Reader, Long> {
    @Override
    List<Reader> findAll();

    @Override
    Reader save(Reader reader);

    @Override
    Optional<Reader> findById(Long id);

    @Override
    void deleteById(Long id);

    @Override
    long count();
}