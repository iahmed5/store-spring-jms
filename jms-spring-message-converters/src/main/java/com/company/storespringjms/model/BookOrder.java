package com.company.storespringjms.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class BookOrder {
    private String bookOrderId;
    private Book book;
    private Customer customer;

    //annotations for jackson to know in which order to pass fields in the constuctor
    @JsonCreator
    public BookOrder(
            @JsonProperty("bookOrderId") String bookOrderId,
            @JsonProperty("book") Book book,
            @JsonProperty("customer") Customer customer) {
        this.bookOrderId = bookOrderId;
        this.book = book;
        this.customer = customer;
    }
}
