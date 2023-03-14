package ru.otus.library.facade.book;

import ru.otus.library.entity.Book;

public interface BookFacade {
  void create(Long authorId, Long genreId, String name);
  Book read(Long id);
  void update(Long id, Long authorId, Long genreId, String name);
  void delete(Long id);
}
