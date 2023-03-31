package ru.otus.library.repository.author;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.library.entity.Author;

@DisplayName("Тестирование слоя repository для сущности Author")
@SpringBootTest
@Transactional
class AuthorRepositoryImplTest {

  @Autowired
  private AuthorRepositoryImpl dao;

  @Test
  void getById() {
    Author result = dao.findById(100);
    Assertions.assertNotNull(result);
  }

  @Test
  void save() {
    String authorName = "Test";
    Author author = Author.builder()
        .name(authorName)
        .build();

    dao.save(author);
    Author result = dao.findById(1);
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
    Author result = dao.findById(authorId);
    Assertions.assertNotNull(result);
    Assertions.assertEquals(authorName, result.getName());
  }

  @Test
  void delete() {
    long authorId = 101L;
    dao.delete(authorId);
    Author result = dao.findById(authorId);
    Assertions.assertNull(result);
  }
}