package ru.otus.library.repository.genre;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.library.entity.Genre;

@DisplayName("Тестирование слоя repository для сущности Genre")
@SpringBootTest
@Transactional
class GenreRepositoryImplTest {

  @Autowired
  private GenreRepositoryImpl repository;

  @Test
  void getById() {
    Genre result = repository.findById(100);
    Assertions.assertNotNull(result);
  }

  @Test
  void save() {
    String genreName = "Test";
    Genre genre = Genre.builder()
        .name(genreName)
        .build();

    repository.save(genre);
    Genre result = repository.findById(1);
    Assertions.assertNotNull(result);
    Assertions.assertEquals(genreName, result.getName());
  }

  @Test
  void update() {
    long genreId = 100L;
    String genreName = "Test";
    Genre genre = Genre.builder()
        .id(genreId)
        .name(genreName)
        .build();

    repository.update(genre);
    Genre result = repository.findById(genreId);
    Assertions.assertNotNull(result);
    Assertions.assertEquals(genreName, result.getName());
  }

  @Test
  void delete() {
    long authorId = 101L;
    repository.delete(authorId);
    Genre result = repository.findById(authorId);
    Assertions.assertNull(result);
  }
}