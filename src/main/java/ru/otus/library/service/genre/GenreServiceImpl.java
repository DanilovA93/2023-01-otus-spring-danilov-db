package ru.otus.library.service.genre;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.library.dto.GenreDTO;
import ru.otus.library.entity.Genre;
import ru.otus.library.mapper.GenreMapper;
import ru.otus.library.repository.GenreRepository;

@Component
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

  private final GenreRepository genreRepository;

  @Override
  public void create(String name) {
    Genre genre = Genre.builder()
        .name(name)
        .build();

    genreRepository.save(genre);
  }

  @Override
  @Transactional(readOnly = true)
  public List<GenreDTO> findAll() {
    return genreRepository.findAll().stream()
        .map(GenreMapper::map)
        .collect(Collectors.toList());
  }

  @Override
  @Transactional(readOnly = true)
  public GenreDTO findById(String id) {
    return GenreMapper.map(getById(id));
  }

  @Override
  public Genre getById(String id) {
    return genreRepository
        .findById(id)
        .orElseThrow(() -> new RuntimeException("Genre with id " + id + "  not found"));
  }

  @Override
  @Transactional
  public void update(String id, String name) {
    Genre genre = getById(id);
    genre.setName(name);

    genreRepository.save(genre);
  }

  @Override
  public void delete(String id) {
    genreRepository.deleteById(id);
  }
}
