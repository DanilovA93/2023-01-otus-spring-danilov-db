package ru.otus.library.service.genre;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.library.dao.genre.GenreDao;
import ru.otus.library.entity.Genre;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

  private final GenreDao genreDao;

  @Override
  public void save(Genre genre) {
    genreDao.save(genre);
  }

  @Override
  public Genre getById(Long id) {
    return genreDao.getById(id);
  }

  @Override
  public void update(Genre genre) {
    genreDao.update(genre);
  }

  @Override
  public void delete(Long id) {
    genreDao.delete(id);
  }
}
