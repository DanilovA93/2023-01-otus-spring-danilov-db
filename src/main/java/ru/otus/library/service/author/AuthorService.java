package ru.otus.library.service.author;

import java.util.List;
import ru.otus.library.dto.AuthorDTO;

public interface AuthorService {
  void create(String name);
  List<AuthorDTO> findAll();
  AuthorDTO findById(Long id);
  void update(Long id, String name);
  void delete(Long id);
}
