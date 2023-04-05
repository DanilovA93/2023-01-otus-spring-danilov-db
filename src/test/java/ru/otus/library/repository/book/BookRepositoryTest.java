package ru.otus.library.repository.book;

import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.library.entity.Author;
import ru.otus.library.entity.Book;
import ru.otus.library.entity.Genre;

@DisplayName("Тестирование слоя repository для сущности Book")
@SpringBootTest
@Transactional
class BookRepositoryTest {

  @Autowired
  private BookRepository repository;

  private Author author = new Author(100L, "AuthorTest", new ArrayList<>());
  private Genre genre = new Genre(100L, "GenreTest", new ArrayList<>());

  @Test
  void getById() {
    Book result = repository.findById(100);
    Assertions.assertNotNull(result);
  }

  @Test
  void save() {
    String bookName = "Test";
    Book book = Book.builder()
        .name(bookName)
        .author(author)
        .genre(genre)
        .build();

    repository.save(book);
    Book result = repository.findById(1);
    Assertions.assertNotNull(result);
    Assertions.assertEquals(bookName, result.getName());
  }

  @Test
  void update() {
    long bookId = 100L;
    String bookName = "Test";
    Book book = Book.builder()
        .id(bookId)
        .name(bookName)
        .author(author)
        .genre(genre)
        .build();

    repository.update(book);
    Book result = repository.findById(bookId);
    Assertions.assertNotNull(result);
    Assertions.assertEquals(bookName, result.getName());
  }

  @Test
  void delete() {
    long bookId = 100L;

    Assertions.assertDoesNotThrow(
        () -> repository.delete(bookId)
    );
  }
}
