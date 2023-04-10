package ru.otus.library.service.book;

import java.util.List;
import ru.otus.library.dto.BookDTO;
import ru.otus.library.entity.Book;

public interface BookService {
  void create(Long authorId, Long genreId, String name);
  List<BookDTO> findAll();
  BookDTO findById(Long id);
  Book getById(Long id);
  void update(Long id, Long authorId, Long genreId, String name);
  void delete(Long id);
}
