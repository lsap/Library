package io.github.lsap.persistence;

public class Book {

    private long id;
    private String title;
    private String author;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return id + "." + title + "." + author;
    }

}
