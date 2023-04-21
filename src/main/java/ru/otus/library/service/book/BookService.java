package ru.otus.library.service.book;

import java.util.List;
import ru.otus.library.dto.BookDTO;
import ru.otus.library.entity.Book;

public interface BookService {
  Book save(Book book);
  void create(String authorId, String genreId, String name);
  List<BookDTO> findAll();
  BookDTO findById(String id);
  Book getById(String id);
  void update(String id, String authorId, String genreId, String name);
  void delete(String id);
}
