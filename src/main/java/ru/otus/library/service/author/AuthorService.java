package ru.otus.library.service.author;

import java.util.List;
import ru.otus.library.dto.AuthorDTO;
import ru.otus.library.entity.Author;

public interface AuthorService {
  void create(String name);
  List<AuthorDTO> findAll();
  AuthorDTO findById(String id);
  Author getById(String id);
  void update(String id, String name);
  void delete(String id);
}
