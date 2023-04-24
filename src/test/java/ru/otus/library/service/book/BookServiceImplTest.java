package ru.otus.library.service.book;

import static org.mockito.Mockito.doReturn;

import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.library.dto.BookDTO;
import ru.otus.library.entity.Author;
import ru.otus.library.entity.Book;
import ru.otus.library.entity.Genre;
import ru.otus.library.repository.BookRepository;

@SpringBootTest
class BookServiceImplTest {

  @Mock
  private BookRepository repository;

  @InjectMocks
  private BookServiceImpl service;

  @Test
  void findById() {
    Optional<Book> optionalBook = Optional.of(Book.builder()
        .id("1")
        .name("")
        .author(Author.builder().build())
        .genre(Genre.builder().build())
        .build()
    );
    Book book = optionalBook.get();

    doReturn(optionalBook).when(repository).findById("1");

    BookDTO result = service.findById("1");

    Assertions.assertNotNull(result);
    Assertions.assertEquals(book.getId(), result.getId());
  }
}