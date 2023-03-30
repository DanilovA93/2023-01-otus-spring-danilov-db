package ru.otus.library.service.genre;

import java.util.List;
import ru.otus.library.entity.Genre;

public interface GenreService {
  void create(String name);
  List<Genre> findAll();
  Genre findById(Long id);
  void update(Long id, String name);
  void delete(Long id);
}
