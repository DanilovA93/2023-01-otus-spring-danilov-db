package ru.otus.library.service;

public interface BaseCrudService<T> {
  void save(T o);
  T getById(Long id);
  void update(T o);
  void delete(Long id);
}
