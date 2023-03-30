package ru.otus.library.repository.genre;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.otus.library.entity.Genre;

@DisplayName("Genre DAO test")
@JdbcTest
@Import(GenreRepositoryImpl.class)
class GenreRepositoryImplTest {

  @Autowired
  private GenreRepositoryImpl dao;

  @Test
  void getById() {
    Genre result = dao.findById(100);
    Assertions.assertNotNull(result);
  }

  @Test
  void save() {
    String genreName = "Test";
    Genre genre = Genre.builder()
        .name(genreName)
        .build();

    dao.save(genre);
    Genre result = dao.findById(1);
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

    dao.update(genre);
    Genre result = dao.findById(genreId);
    Assertions.assertNotNull(result);
    Assertions.assertEquals(genreName, result.getName());
  }

  @Test
  void delete() {
    long authorId = 101L;
    dao.delete(authorId);
    Genre result = dao.findById(authorId);
    Assertions.assertNull(result);
  }
}