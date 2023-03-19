package ru.otus.library.dao.author;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.otus.library.entity.Author;

@DisplayName("Author DAO test")
@JdbcTest
@Import(AuthorDaoImpl.class)
class AuthorDaoImplTest {

  @Autowired
  private AuthorDaoImpl dao;

  @Test
  void getById() {
    Author result = dao.getById(100);
    Assertions.assertNotNull(result);
  }

  @Test
  void save() {
    String authorName = "Test";
    Author author = Author.builder()
        .name(authorName)
        .build();

    dao.save(author);
    Author result = dao.getById(1);
    Assertions.assertNotNull(result);
    Assertions.assertEquals(authorName, result.getName());
  }

  @Test
  void update() {
    long authorId = 100L;
    String authorName = "Test";
    Author author = Author.builder()
        .id(authorId)
        .name(authorName)
        .build();

    dao.update(author);
    Author result = dao.getById(authorId);
    Assertions.assertNotNull(result);
    Assertions.assertEquals(authorName, result.getName());
  }

  @Test
  void delete() {
    long authorId = 101L;
    dao.delete(authorId);
    Author result = dao.getById(authorId);
    Assertions.assertNull(result);
  }
}