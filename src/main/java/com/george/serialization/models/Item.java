package com.george.serialization.models;

import java.util.List;

public class Item {

    public int itemId;
    public String itemName;
    public User user;
    public List<Books> books;
    public List<String> autos;

    public Item() { }

    public Item(int itemId, String itemName, User user, List<Books> books, List<String> autos) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.user = user;
        this.books = books;
        this.autos = autos;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }

    public List<String> getAutos() {
        return autos;
    }

    public void setAutos(List<String> autos) {
        this.autos = autos;
    }

}
