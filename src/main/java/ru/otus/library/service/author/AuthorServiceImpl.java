package ru.otus.library.service.author;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.library.dao.author.AuthorDao;
import ru.otus.library.entity.Author;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

  private final AuthorDao authorDao;

  @Override
  public void save(Author author) {
    authorDao.save(author);
  }

  @Override
  public Author getById(Long id) {
    return authorDao.getById(id);
  }

  @Override
  public void update(Author author) {
    authorDao.update(author);
  }

  @Override
  public void delete(Long id) {
    authorDao.delete(id);
  }
}
