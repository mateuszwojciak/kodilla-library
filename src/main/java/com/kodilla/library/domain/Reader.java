package com.kodilla.library.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "READERS")
public class Reader {

    private Long id;
    private String name;
    private String surname;
    private LocalDate dateOfCardInsertion = LocalDate.now();
    private Borrow borrow;

    public Reader() {}

    public Reader(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "SURNAME")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @NotNull
    @Column(name = "DATE")
    public LocalDate getDateOfCardInsertion() {
        return dateOfCardInsertion;
    }

    public void setDateOfCardInsertion(LocalDate dateOfCardInsertion) {
        this.dateOfCardInsertion = dateOfCardInsertion;
    }
    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }

    @Transient
    public Borrow getBorrow() {
        return borrow;
    }
}
