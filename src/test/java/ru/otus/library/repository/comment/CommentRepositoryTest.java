package ru.otus.library.repository.comment;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.library.entity.Book;
import ru.otus.library.entity.Comment;
import ru.otus.library.repository.BookRepository;
import ru.otus.library.repository.CommentRepository;

@DisplayName("Тестирование слоя repository для сущности Comment")
@SpringBootTest
@AutoConfigureDataMongo
class CommentRepositoryTest {

  @Autowired
  private BookRepository bookRepository;

  @Autowired
  private CommentRepository commentRepository;

  @Test
  @DisplayName("Поиск комментариев по id книги")
  void findAllByBookId() {
    Book book = bookRepository.findAllByName("Dubrovsky");
    List<Comment> comment = commentRepository.findAllByBookId(book.getId());
    Assertions.assertEquals(2, comment.size());
  }
}
