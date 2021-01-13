package com.kodilla.library.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;


@NamedQuery(
        name = "Copy.getCopiesInLibraryForTitle",
        query = "FROM Copy WHERE status = 'In library' AND tiltle LIKE CONCAT('%', :ARG ,'%')"
)

@Entity
@Table(name = "COPIES")
public class Copy {

    private Long id;
    private String status;
    private Book book;
    private String title;

    public Copy() {}

    public Copy(Long id, String status, String title) {
        this.id = id;
        this.status = status;
        this.title = title;
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

    @ManyToOne
    @JoinColumn(name = "ID_TITLE")
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Column(name = "STATUS")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Transient
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
