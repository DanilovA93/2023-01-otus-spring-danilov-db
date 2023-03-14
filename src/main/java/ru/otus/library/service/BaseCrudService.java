package ru.otus.library.service;

public interface BaseCrudService<T> {
  void save(T book);
  T get(Long id);
  void update(T book);
  void delete(Long id);
}
