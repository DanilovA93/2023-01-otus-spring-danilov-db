package ru.otus.library.service.genre;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.library.dto.GenreDTO;
import ru.otus.library.entity.Genre;
import ru.otus.library.mapper.GenreMapper;
import ru.otus.library.repository.genre.GenreRepository;

@Component
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

  private final GenreRepository genreRepository;

  @Override
  @Transactional
  public void create(String name) {
    Genre genre = Genre.builder()
        .name(name)
        .build();

    genreRepository.save(genre);
  }

  @Override
  public List<GenreDTO> findAll() {
    return genreRepository.findAll().stream()
        .map(GenreMapper::map)
        .collect(Collectors.toList());
  }

  @Override
  public GenreDTO findById(Long id) {
    return GenreMapper.map(genreRepository.findById(id));
  }

  @Override
  @Transactional
  public void update(Long id, String name) {
    Genre genre = genreRepository.findById(id);
    genre.setName(name);

    genreRepository.update(genre);
  }

  @Override
  @Transactional
  public void delete(Long id) {
    genreRepository.delete(id);
  }
}
