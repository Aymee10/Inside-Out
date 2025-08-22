package dev.aymee.repository;

import java.util.List;

public interface Repository<T> {
    void add(T entity);
    List<T> findAll();
    boolean delete(int id);
    String saveCSV();
}