package ru.otus.library.repository.genre;

import java.util.List;
import ru.otus.library.entity.Genre;

public interface GenreRepository {
  void save(Genre o);
  List<Genre> findAll();
  Genre findById(long id);
  Genre update(Genre o);
  void delete(Long id);
}
