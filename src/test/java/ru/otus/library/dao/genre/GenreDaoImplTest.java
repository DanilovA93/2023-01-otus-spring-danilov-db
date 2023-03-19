package ru.otus.library.dao.genre;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.otus.library.dao.author.AuthorDaoImpl;
import ru.otus.library.entity.Author;
import ru.otus.library.entity.Genre;

@DisplayName("Genre DAO test")
@JdbcTest
@Import(GenreDaoImpl.class)
class GenreDaoImplTest {

  @Autowired
  private GenreDaoImpl dao;

  @Test
  void getById() {
    Genre result = dao.getById(100);
    Assertions.assertNotNull(result);
  }

  @Test
  void save() {
    String genreName = "Test";
    Genre genre = Genre.builder()
        .name(genreName)
        .build();

    dao.save(genre);
    Genre result = dao.getById(1);
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
    Genre result = dao.getById(genreId);
    Assertions.assertNotNull(result);
    Assertions.assertEquals(genreName, result.getName());
  }

  @Test
  void delete() {
    long authorId = 101L;
    dao.delete(authorId);
    Genre result = dao.getById(authorId);
    Assertions.assertNull(result);
  }
}