package ru.otus.library.dao.author;

import ru.otus.library.entity.Author;

public interface AuthorDao {
  void save(Author o);
  Author getById(long id);
  void update(Author o);
  void delete(Long id);
}
