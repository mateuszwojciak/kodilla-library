package com.kodilla.library.repository;

import com.kodilla.library.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    @Override
    List<Book> findAll();

    @Override
    Book save(Book book);

    @Override
    Optional<Book> findById(Long id);

    Optional<Book> findByTitle(String title);

    @Override
    void deleteById(Long id);

    @Override
    long count();
}