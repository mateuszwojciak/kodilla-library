package com.kodilla.library.service;

import com.kodilla.library.domain.Borrow;
import com.kodilla.library.domain.Copy;
import com.kodilla.library.domain.Reader;
import com.kodilla.library.repository.BorrowRepository;
import com.kodilla.library.repository.CopyRepository;
import com.kodilla.library.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DbServiceBorrow {

    @Autowired
    BorrowRepository borrowRepository;

    @Autowired
    CopyRepository copyRepository;

    @Autowired
    ReaderRepository readerRepository;

    public List<Borrow> getAllBorrows() {
        return borrowRepository.findAll();
    }

    public Optional<Borrow> getBorrow(Long id) {
        return borrowRepository.findById(id);
    }

    public Borrow saveBorrow(final Borrow borrow) {
        Optional<Reader> readerOptional = readerRepository.findById(borrow.getId_reader());
        Reader reader = readerOptional.get();
        borrow.setReader(reader);
        Optional<Copy> copyOptional = copyRepository.findById(borrow.getId_copy());
        Copy copy = copyOptional.get();
        borrow.setCopy(copy);
        if(borrow.getReturned().equals("No")) {
            copy.setStatus("Borrowed");
        } else {
            copy.setStatus("In library");
            borrow.setReturnOfDate(LocalDate.now());
        }
        return borrowRepository.save(borrow);
    }

    public void deleteBorrow(final Long id) {
        borrowRepository.deleteById(id);
    }

}
