package ru.otus.library.service.genre;

import java.util.List;
import ru.otus.library.dto.GenreDTO;
import ru.otus.library.entity.Genre;

public interface GenreService {
  void create(String name);
  List<GenreDTO> findAll();
  GenreDTO findById(String id);
  Genre getById(String id);
  void update(String id, String name);
  void delete(String id);
}
