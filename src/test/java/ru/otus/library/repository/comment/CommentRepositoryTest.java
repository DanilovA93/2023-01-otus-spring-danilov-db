package ru.otus.library.repository.comment;

import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.library.entity.Book;
import ru.otus.library.entity.Comment;
import ru.otus.library.repository.book.BookRepository;

@DisplayName("Тестирование слоя repository для сущности Book")
@SpringBootTest
@Transactional
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CommentRepositoryTest {

  @Autowired
  private CommentRepository repository;

  @Autowired
  private BookRepository bookRepository;

  private Book book;

  @BeforeAll
  public void before() {
    this.book = bookRepository.findById(100);
  }

  @Test
  void getById() {
    Comment result = repository.findById(100);
    Assertions.assertNotNull(result);
  }

  @Test
  void save() {
    String text = RandomString.make(5);
    Comment comment = Comment.builder()
        .text(text)
        .book(book)
        .build();

    repository.save(comment);
    Comment result = repository.findById(1);

    Assertions.assertNotNull(result);
    Assertions.assertEquals(text, result.getText());
  }

  @Test
  void update() {
    long bookId = 100L;
    String text = RandomString.make(5);
    Comment comment = Comment.builder()
        .id(bookId)
        .text(text)
        .book(book)
        .build();

    repository.update(comment);
    Comment result = repository.findById(bookId);
    Assertions.assertNotNull(result);
    Assertions.assertEquals(text, result.getText());
  }

  @Test
  void delete() {
    long commentId = 100L;

    repository.deleteById(commentId);
    Comment result = repository.findById(commentId);
    Assertions.assertNull(result);
  }
}
