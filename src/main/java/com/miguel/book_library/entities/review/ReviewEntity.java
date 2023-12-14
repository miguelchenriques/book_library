package com.miguel.book_library.entities.review;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int book;
    private float rating;
    @Column(columnDefinition = "text")
    private String comment;

    public ReviewEntity() {
    }

    public ReviewEntity(int book, float rating, String comment) {
        this.book = book;
        this.rating = rating;
        this.comment = comment;
    }

    public int getBook() {
        return book;
    }

    public float getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }
}
