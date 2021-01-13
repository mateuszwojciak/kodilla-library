package com.kodilla.library.domain;

public class CopyDto {
    private Long id;
    private String status;
    private BookDto bookDto;
    private String title;

    public CopyDto() {}

    public CopyDto(Long id, String status, String title) {
        this.id = id;
        this.status = status;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BookDto getBookDto() {
        return bookDto;
    }

    public void setBookDto(BookDto bookDto) {
        this.bookDto = bookDto;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
