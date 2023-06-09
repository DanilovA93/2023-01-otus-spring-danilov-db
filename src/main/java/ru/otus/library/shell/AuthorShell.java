package ru.otus.library.shell;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.library.dto.AuthorDTO;
import ru.otus.library.service.author.AuthorService;

@ShellComponent
@RequiredArgsConstructor
public class AuthorShell {

  private final AuthorService authorService;

  @ShellMethod(
      key = {"ac", "author-create"},
      value = "Create an author"
  )
  public void create(@ShellOption({"n", "name"}) String name) {
    authorService.create(name);
  }

  @ShellMethod(
      key = {"ara", "author-reed-all"},
      value = "Reed all authors"
  )
  public List<AuthorDTO> findAll() {
    return authorService.findAll();
  }

  @ShellMethod(
      key = {"ar", "author-reed"},
      value = "Reed the author"
  )
  public AuthorDTO findById(@ShellOption({"id"}) String id) {
    return authorService.findById(id);
  }

  @ShellMethod(
      key = {"au", "author-update"},
      value = "Update the author"
  )
  public void update(
      @ShellOption({"id"}) String id,
      @ShellOption({"n", "name"}) String name
  ) {
    authorService.update(id, name);
  }

  @ShellMethod(
      key = {"ad", "author-delete"},
      value = "Delete the author"
  )
  public void delete(@ShellOption({"id"}) String id) {
    authorService.delete(id);
  }
}
