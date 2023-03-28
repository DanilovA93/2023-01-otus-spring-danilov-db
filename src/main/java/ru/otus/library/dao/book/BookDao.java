package ru.otus.library.dao.book;

import ru.otus.library.entity.Book;

public interface BookDao {
  void save(Book o);
  Book getById(long id);
  void update(Book o);
  void delete(Long id);
}
