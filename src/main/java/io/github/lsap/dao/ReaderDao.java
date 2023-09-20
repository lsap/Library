package io.github.lsap.dao;

import io.github.lsap.persistence.Reader;

import java.util.List;

public interface ReaderDao {

    List<Reader> getAll();
}

