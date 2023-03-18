package ru.otus.library.dao.genre;

import ru.otus.library.entity.Genre;

public interface GenreDao {
  void save(Genre o);
  Genre getById(long id);
  void update(Genre o);
  void delete(Long id);
}
