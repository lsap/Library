package io.github.lsap.persistence;

public class Reader {

    private long id;
    private String name;

    public Reader() {}

    public Reader(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id + "." + name;
    }
}
