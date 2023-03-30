package ru.otus.library.service.author;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.library.entity.Author;
import ru.otus.library.repository.author.AuthorRepository;

@Component
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

  private final AuthorRepository authorRepository;

  @Override
  @Transactional
  public void create(String name) {
    Author author = Author.builder()
        .name(name)
        .build();

    authorRepository.save(author);
  }

  @Transactional(readOnly = true)
  public List<Author> findAll() {
    return authorRepository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Author findById(Long id) {
    return authorRepository.findById(id);
  }

  @Override
  @Transactional
  public void update(Long id, String name) {
    Author author = authorRepository.findById(id);
    author.setName(name);

    authorRepository.update(author);
  }

  @Override
  @Transactional
  public void delete(Long id) {
    authorRepository.delete(id);
  }
}
