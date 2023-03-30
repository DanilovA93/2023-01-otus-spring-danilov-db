package ru.otus.library.service.author;

import java.util.List;
import ru.otus.library.entity.Author;

public interface AuthorService {
  void create(String name);
  List<Author> findAll();
  Author findById(Long id);
  void update(Long id, String name);
  void delete(Long id);
}
