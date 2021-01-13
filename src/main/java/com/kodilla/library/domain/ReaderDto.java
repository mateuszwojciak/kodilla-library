package com.kodilla.library.domain;

import java.time.LocalDate;

public class ReaderDto {
    private Long id;
    private String name;
    private String surname;
    private LocalDate dateOfCardInsertion;
    private Borrow borrow;

    public ReaderDto() {}

    public ReaderDto(Long id, String name, String surname, LocalDate dateOfCardInsertion) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfCardInsertion = dateOfCardInsertion;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDateOfCardInsertion() {
        return dateOfCardInsertion;
    }

    public Borrow getBorrow() {
        return borrow;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDateOfCardInsertion(LocalDate dateOfCardInsertion) {
        this.dateOfCardInsertion = dateOfCardInsertion;
    }

    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }
}
