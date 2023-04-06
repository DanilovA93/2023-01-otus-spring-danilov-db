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
  private AuthorRepositoryImpl repository;

  @Test
  void getById() {
    Author result = repository.findById(100);
    Assertions.assertNotNull(result);
  }

  @Test
  void save() {
    String authorName = "Test";
    Author author = Author.builder()
        .name(authorName)
        .build();

    repository.save(author);
    Author result = repository.findById(1);
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

    repository.update(author);
    Author result = repository.findById(authorId);
    Assertions.assertNotNull(result);
    Assertions.assertEquals(authorName, result.getName());
  }

  @Test
  void delete() {
    long authorId = 101L;
    repository.delete(authorId);
    Author result = repository.findById(authorId);
    Assertions.assertNull(result);
  }
}