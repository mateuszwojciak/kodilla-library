package com.kodilla.library.controller;

import com.kodilla.library.domain.Borrow;
import com.kodilla.library.domain.BorrowDto;
import com.kodilla.library.mapper.BorrowMapper;
import com.kodilla.library.service.DbServiceBorrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/borrow")
public class BorrowController {
    @Autowired
    private DbServiceBorrow dbServiceBorrow;

    @Autowired
    private BorrowMapper borrowMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getBorrows") //check the borrows !!!!
    public List<BorrowDto> getBorrows() {
        return borrowMapper.mapToBorrowDtoList(dbServiceBorrow.getAllBorrows());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBorrow")
    public BorrowDto getBorrow(@RequestParam Long borrowId) throws BookNotFoundException {
        return borrowMapper.mapToBorrowDto(dbServiceBorrow.getBorrow(borrowId).orElseThrow(BookNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteBorrow")
    public void deleteBorrow(@RequestParam Long borrowId) {
        dbServiceBorrow.deleteBorrow(borrowId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateBorrow")
    public BorrowDto updateBorrow(@RequestBody BorrowDto borrowDto) {
        return borrowMapper.mapToBorrowDto(dbServiceBorrow.saveBorrow(borrowMapper.mapToBorrow(borrowDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBorrow", consumes = APPLICATION_JSON_VALUE)
    public void createBorrow(@RequestBody BorrowDto borrowDto) {
        dbServiceBorrow.saveBorrow(borrowMapper.mapToBorrow(borrowDto));
    }
}
