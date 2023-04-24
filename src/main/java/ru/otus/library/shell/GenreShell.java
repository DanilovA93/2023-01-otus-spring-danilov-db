package ru.otus.library.shell;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.library.dto.GenreDTO;
import ru.otus.library.service.genre.GenreService;

@ShellComponent
@RequiredArgsConstructor
public class GenreShell {

  private final GenreService genreService;

  @ShellMethod(
      key = {"gc", "genre-create"},
      value = "Create a genre"
  )
  public void create(@ShellOption({"name", "n"}) String name) {
    genreService.create(name);
  }

  @ShellMethod(
      key = {"gra", "genre-reed-all"},
      value = "Genre all books"
  )
  public List<GenreDTO> findAll() {
    return genreService.findAll();
  }

  @ShellMethod(
      key = {"gr", "genre-reed"},
      value = "Reed the genre"
  )
  public GenreDTO findById(
      @ShellOption({"id"}) String id
  ){
    return genreService.findById(id);
  }

  @ShellMethod(
      key = {"gu", "genre-update"},
      value = "Update the genre"
  )
  public void update(
      @ShellOption({"id"}) String id,
      @ShellOption({"n", "name"}) String name
  ) {
    genreService.update(id, name);
  }

  @ShellMethod(
      key = {"gd", "genre-delete"},
      value = "Delete the genre"
  )
  public void delete(@ShellOption({"id"}) String id) {
    genreService.delete(id);
  }
}