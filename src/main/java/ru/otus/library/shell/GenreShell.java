package ru.otus.library.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.library.entity.Genre;
import ru.otus.library.facade.genre.GenreFacade;

@ShellComponent(value = "AWDAWdwd")
@RequiredArgsConstructor
public class GenreShell {

  private final GenreFacade genreFacade;

  @ShellMethod(
      key = {"gc", "genre-create"},
      value = "Create a genre"
  )
  public void create(@ShellOption({"name", "n"}) String name) {
    genreFacade.create(name);
  }

  @ShellMethod(
      key = {"gr", "genre-reed"},
      value = "Reed the genre"
  )
  public Genre read(@ShellOption({"id"}) Long id) {
    return genreFacade.read(id);
  }

  @ShellMethod(
      key = {"gu", "genre-update"},
      value = "Update the genre"
  )
  public void update(
      @ShellOption({"id"}) Long id,
      @ShellOption({"n", "name"}) String name
  ) {
    genreFacade.update(id, name);
  }

  @ShellMethod(
      key = {"gd", "genre-delete"},
      value = "Delete the genre"
  )
  public void delete(@ShellOption({"id"}) Long id) {
    genreFacade.delete(id);
  }
}