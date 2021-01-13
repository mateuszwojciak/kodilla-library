package com.kodilla.library.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "BORROW")
public class Borrow {

    private Long id;
    private Copy copy;
    private Reader reader;
    private Long id_copy;
    private Long id_reader;
    private String returned;
    private LocalDate borrowOfDate = LocalDate.now();
    private LocalDate returnOfDate;

    public Borrow() {}

    public Borrow(Long id, Long id_copy, Long id_reader, String returned) {
        this.id = id;
        this.id_copy = id_copy;
        this.id_reader = id_reader;
        this.returned = returned;
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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_COPY")
    public Copy getCopy() {
        return copy;
    }

    public void setCopy(Copy copy) {
        this.copy = copy;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_READER")
    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    @NotNull
    @Column(name = "BORROW_OF_DATE")
    public LocalDate getBorrowOfDate() {
        return borrowOfDate;
    }

    public void setBorrowOfDate(LocalDate borrowOfDate) {
        this.borrowOfDate = borrowOfDate;
    }

    @Column(name = "RETURN_OF_DATE")
    public LocalDate getReturnOfDate() {
        return returnOfDate;
    }

    public void setReturnOfDate(LocalDate returnOfDate) {
        this.returnOfDate = returnOfDate;
    }

    @Transient
    public Long getId_copy() {
        return id_copy;
    }

    public void setId_copy(Long id_copy) {
        this.id_copy = id_copy;
    }

    @Transient
    public Long getId_reader() {
        return id_reader;
    }

    public void setId_reader(Long id_reader) {
        this.id_reader = id_reader;
    }

    @Transient
    public String getReturned() {
        return returned;
    }

    public void setReturned(String returned) {
        this.returned = returned;
    }
}