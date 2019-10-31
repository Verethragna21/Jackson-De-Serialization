package com.george.serialization.models;

public class Books {

    private String bookName;
    private String bookCategory;

    public Books() {

    }

    public Books(String bookName, String bookCategory) {
        this.bookName = bookName;
        this.bookCategory = bookCategory;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }
}
