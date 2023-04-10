package ru.otus.library.service.author;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.library.dto.AuthorDTO;
import ru.otus.library.entity.Author;
import ru.otus.library.mapper.AuthorMapper;
import ru.otus.library.repository.AuthorRepository;

@Component
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

  private final AuthorRepository authorRepository;

  @Override
  public void create(String name) {
    Author author = Author.builder()
        .name(name)
        .build();

    authorRepository.save(author);
  }

  @Override
  public List<AuthorDTO> findAll() {
    return authorRepository.findAll().stream()
        .map(AuthorMapper::map)
        .collect(Collectors.toList());
  }

  @Override
  public AuthorDTO findById(Long id) {
    return AuthorMapper.map(getById(id));
  }

  @Override
  public Author getById(Long id) {
    return authorRepository
        .findById(id)
        .orElseThrow(() -> new RuntimeException("Author with id " + id + "  not found"));
  }

  @Override
  @Transactional
  public void update(Long id, String name) {
    Author author = getById(id);
    author.setName(name);

    authorRepository.save(author);
  }

  @Override
  public void delete(Long id) {
    authorRepository.deleteById(id);
  }
}
