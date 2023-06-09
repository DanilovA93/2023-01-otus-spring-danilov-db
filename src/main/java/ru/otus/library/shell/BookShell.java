package ru.otus.library.shell;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.library.dto.BookDTO;
import ru.otus.library.service.book.BookService;

@ShellComponent
@RequiredArgsConstructor
public class BookShell {

  private final BookService bookService;

  @ShellMethod(
      key = {"bc", "book-create"},
      value = "Create a book"
  )
  public void create(
      @ShellOption({"aid", "author-id"}) String authorId,
      @ShellOption({"gid", "genre-id"}) String genreId,
      @ShellOption({"n", "name"}) String name
  ) {
    bookService.create(authorId, genreId, name);
  }

  @ShellMethod(
      key = {"bra", "book-reed-all"},
      value = "Reed all books"
  )
  public List<BookDTO> findAll() {
    return bookService.findAll();
  }

  @ShellMethod(
      key = {"br", "book-reed"},
      value = "Reed the book"
  )
  public BookDTO findById(
      @ShellOption({"id"}) String id
  ){
    return bookService.findById(id);
  }

  @ShellMethod(
      key = {"bu", "book-update"},
      value = "Update the book"
  )
  public void update(
      @ShellOption({"id"}) String id,
      @ShellOption({"aid", "author-id"}) String authorId,
      @ShellOption({"gid", "genre-id"}) String genreId,
      @ShellOption({"n", "name"}) String name
  ) {
    bookService.update(id, authorId, genreId, name);
  }

  @ShellMethod(
      key = {"bd", "book-delete"},
      value = "Delete the book"
  )
  public void delete(@ShellOption({"id"}) String id) {
    bookService.delete(id);
  }
}
