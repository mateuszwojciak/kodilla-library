package com.kodilla.library.controller;

import com.kodilla.library.domain.BookDto;
import com.kodilla.library.mapper.BookMapper;
import com.kodilla.library.mapper.CopyMapper;
import com.kodilla.library.service.DbServiceBook;
import com.kodilla.library.service.DbServiceCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/book")
public class BookController {
    @Autowired
    private DbServiceBook dbServiceBook;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private DbServiceCopy dbServiceCopy;

    @Autowired
    private CopyMapper copyMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getBooks")
    public List<BookDto> getBooks() {
        return bookMapper.mapToBookDtoList(dbServiceBook.getAllBooks());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBook")
    public BookDto getBook(@RequestParam Long bookId) throws BookNotFoundException {
        return bookMapper.mapToBookDto(dbServiceBook.getBook(bookId).orElseThrow(BookNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBookTitle")
    public BookDto getBookTitle(@RequestParam String bookTitle) throws BookNotFoundException {
        return bookMapper.mapToBookDto(dbServiceBook.getBookTitle(bookTitle).orElseThrow(BookNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteBook")
    public void deleteBook(@RequestParam Long bookId) {
        dbServiceBook.deleteBook(bookId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateBook")
    public BookDto updateBook(@RequestBody BookDto bookDto) {
        return bookMapper.mapToBookDto(dbServiceBook.saveBook(bookMapper.mapToBook(bookDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBook", consumes = APPLICATION_JSON_VALUE)
    public void createBook(@RequestBody BookDto bookDto) {
        dbServiceBook.saveBook(bookMapper.mapToBook(bookDto));
    }
}
