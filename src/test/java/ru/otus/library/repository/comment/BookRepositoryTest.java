package ru.otus.library.repository.comment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.library.entity.Book;
import ru.otus.library.repository.BookRepository;

@DisplayName("Тестирование слоя repository для сущности Comment")
@SpringBootTest
@AutoConfigureDataMongo
public class BookRepositoryTest {

  @Autowired
  private BookRepository bookRepository;

  @Test
  @DisplayName("Поиск книги по названию")
  void findAllByName() {
    Book book = bookRepository.findAllByName("Dubrovsky");
    Assertions.assertNotNull(book);
  }
}
