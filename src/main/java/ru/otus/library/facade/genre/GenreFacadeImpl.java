package ru.otus.library.facade.genre;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.library.entity.Genre;
import ru.otus.library.service.genre.GenreService;

@Component
@RequiredArgsConstructor
public class GenreFacadeImpl implements GenreFacade {

  private final GenreService genreService;

  @Override
  public void create(String name) {
    Genre genre = Genre.builder()
        .name(name)
        .build();
    genreService.save(genre);
  }

  @Override
  public Genre read(Long id) {
    return genreService.getById(id);
  }

  @Override
  public void update(Long id, String name) {
    Genre genre = Genre.builder()
        .id(id)
        .name(name)
        .build();
    genreService.update(genre);
  }

  @Override
  public void delete(Long id) {
    genreService.delete(id);
  }
}
