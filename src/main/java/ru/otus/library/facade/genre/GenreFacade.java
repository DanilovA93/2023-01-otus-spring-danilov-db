package ru.otus.library.facade.genre;

import ru.otus.library.entity.Genre;

public interface GenreFacade {
  void create(String name);
  Genre read(Long id);
  void update(Long id, String name);
  void delete(Long id);
}
