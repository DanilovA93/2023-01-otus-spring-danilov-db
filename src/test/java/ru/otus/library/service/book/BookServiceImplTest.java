package ru.otus.library.service.book;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.library.repository.book.BookRepositoryImpl;
import ru.otus.library.entity.Author;
import ru.otus.library.entity.Book;
import ru.otus.library.entity.Genre;

@SpringBootTest
//@RunWith(SpringRunner.class)
class BookServiceImplTest {

  @Mock
  private BookRepositoryImpl bookDao;

  @InjectMocks
  private BookServiceImpl service;

  @Test
  void getById() {
    Book book = Book.builder()
        .id(1L)
        .name("")
        .author(Author.builder().build())
        .genre(Genre.builder().build())
        .build();

    doReturn(book).when(bookDao).findById(1);

    Book result = service.findById(1L);

    Assertions.assertNotNull(result);
    Assertions.assertEquals(book, result);
  }
}