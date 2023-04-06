package ru.otus.library.service.genre;

import java.util.List;
import ru.otus.library.dto.GenreDTO;

public interface GenreService {
  void create(String name);
  List<GenreDTO> findAll();
  GenreDTO findById(Long id);
  void update(Long id, String name);
  void delete(Long id);
}
