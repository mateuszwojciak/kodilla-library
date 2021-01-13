package com.kodilla.library.repository;

import com.kodilla.library.domain.Copy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface CopyRepository extends CrudRepository<Copy, Long> {

    List<Copy> findByStatus(String status);

    @Override
    List<Copy> findAll();

    @Override
    Copy save(Copy copy);

    @Override
    Optional<Copy> findById(Long id);

    @Override
    void deleteById(Long id);

    @Override
    long count();

    @Query
    Long getCopiesInLibraryForTitle(@Param("TITLE") String title, @Param("STATUS") String status);

}