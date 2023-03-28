package ru.otus.library.facade.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.library.entity.Author;
import ru.otus.library.entity.Book;
import ru.otus.library.entity.Genre;
import ru.otus.library.service.author.AuthorService;
import ru.otus.library.service.book.BookService;
import ru.otus.library.service.genre.GenreService;

@Component
@RequiredArgsConstructor
public class BookFacadeImpl implements BookFacade {

  private final BookService bookService;
  private final AuthorService authorService;
  private final GenreService genreService;

  @Override
  public void create(Long authorId, Long genreId, String name) {
    Author author = authorService.getById(authorId);
    Genre genre = genreService.getById(genreId);
    Book book = Book.builder()
        .name(name)
        .author(author)
        .genre(genre)
        .build();

    bookService.save(book);
  }

  @Override
  public Book read(Long id) {
    return bookService.getById(id);
  }

  @Override
  public void update(Long id, Long authorId, Long genreId, String name) {
    Author author = authorService.getById(authorId);
    Genre genre = genreService.getById(genreId);
    Book book = Book.builder()
        .name(name)
        .author(author)
        .genre(genre)
        .build();

    bookService.update(book);
  }

  @Override
  public void delete(Long id) {
    bookService.delete(id);
  }
}
