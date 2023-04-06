package ru.otus.library.repository.comment;

import java.util.List;
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
import ru.otus.library.repository.BookRepository;
import ru.otus.library.repository.CommentRepository;

@DisplayName("Тестирование слоя repository для сущности Book")
@SpringBootTest
@Transactional
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CommentRepositoryTest {

  @Autowired
  private CommentRepository repository;

  @Test
  void findAllByBookId() {
   List<Comment> comment = repository.findAllByBookId(100L);
   Assertions.assertEquals(2, comment.size());
  }
}
