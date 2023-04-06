package ru.otus.library.repository.book;

import java.util.List;
import ru.otus.library.entity.Book;

public interface BookRepository {
  void save(Book o);
  List<Book> findAll();
  Book findById(long id);
  Book update(Book o);
  void delete(Long id);
}
