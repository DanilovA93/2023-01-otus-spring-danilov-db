package ru.otus.library.facade.author;

import ru.otus.library.entity.Author;

public interface AuthorFacade {
  void create(String name);
  Author read(Long id);
  void update(Long id, String name);
  void delete(Long id);
}
