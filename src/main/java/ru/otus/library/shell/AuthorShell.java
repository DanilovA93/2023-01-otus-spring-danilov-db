package ru.otus.library.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.library.entity.Author;
import ru.otus.library.facade.author.AuthorFacade;

@ShellComponent
@RequiredArgsConstructor
public class AuthorShell {

  private final AuthorFacade authorFacade;

  @ShellMethod(
      key = {"ac", "author-create"},
      value = "Create an author"
  )
  public void create(@ShellOption({"n", "name"}) String name) {
    authorFacade.create(name);
  }

  @ShellMethod(
      key = {"ar", "author-reed"},
      value = "Reed the author"
  )
  public Author read(@ShellOption({"id"}) Long id) {
    return authorFacade.read(id);
  }

  @ShellMethod(
      key = {"au", "author-update"},
      value = "Update the author"
  )
  public void update(
      @ShellOption({"id"}) Long id,
      @ShellOption({"n", "name"}) String name
  ) {
    authorFacade.update(id, name);
  }

  @ShellMethod(
      key = {"ad", "author-delete"},
      value = "Delete the author"
  )
  public void delete(@ShellOption({"id"}) Long id) {
    authorFacade.delete(id);
  }
}
