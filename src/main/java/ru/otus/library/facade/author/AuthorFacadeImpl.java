package ru.otus.library.facade.author;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.library.entity.Author;
import ru.otus.library.service.author.AuthorService;

@Component
@RequiredArgsConstructor
public class AuthorFacadeImpl implements AuthorFacade {

  private final AuthorService authorService;

  @Override
  public void create(String name) {
    Author author = Author.builder()
        .name(name)
        .build();
    authorService.save(author);
  }

  @Override
  public Author read(Long id) {
    return authorService.getById(id);
  }

  @Override
  public void update(Long id, String name) {
    Author author = Author.builder()
        .id(id)
        .name(name)
        .build();
    authorService.update(author);
  }

  @Override
  public void delete(Long id) {
    authorService.delete(id);
  }
}
