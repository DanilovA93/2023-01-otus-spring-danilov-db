package ru.otus.library.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.library.entity.Book;
import ru.otus.library.facade.book.BookFacade;

@ShellComponent
@RequiredArgsConstructor
public class BookShell {

  private final BookFacade facade;

  @ShellMethod(
      key = {"bc", "book-create"},
      value = "Create a book"
  )
  public void create(
      @ShellOption({"aid", "author-id"}) Long authorId,
      @ShellOption({"gid", "genre-id"}) Long genreId,
      @ShellOption({"n", "name"}) String name
  ) {
    facade.create(authorId, genreId, name);
  }

  @ShellMethod(
      key = {"br", "book-reed"},
      value = "Reed the book"
  )
  public Book read(@ShellOption({"id"}) Long id) {
    return facade.read(id);
  }

  @ShellMethod(
      key = {"bu", "book-update"},
      value = "Update the book"
  )
  public void update(
      @ShellOption({"id"}) Long id,
      @ShellOption({"aid", "author-id"}) Long authorId,
      @ShellOption({"gid", "genre-id"}) Long genreId,
      @ShellOption({"n", "name"}) String name
  ) {
    facade.update(id, authorId, genreId, name);
  }

  @ShellMethod(
      key = {"bd", "book-delete"},
      value = "Delete the book"
  )
  public void delete(@ShellOption({"id"}) Long id) {
    facade.delete(id);
  }
}
