package com.company.storespringjms.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Book {
    private String bookId;
    private String title;

    public Book(String bookId, String title) {
        this.bookId = bookId;
        this.title = title;
    }
}
