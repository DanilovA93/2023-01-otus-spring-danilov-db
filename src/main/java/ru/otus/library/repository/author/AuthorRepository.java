package ru.otus.library.repository.author;

import java.util.List;
import ru.otus.library.entity.Author;

public interface AuthorRepository {
  void save(Author o);
  List<Author> findAll();
  Author findById(long id);
  Author update(Author o);
  void delete(Long id);
}
