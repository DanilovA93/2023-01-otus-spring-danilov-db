//package ru.otus.library.repository.book;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
//import org.springframework.context.annotation.Import;
//import ru.otus.library.entity.Author;
//import ru.otus.library.entity.Book;
//import ru.otus.library.entity.Genre;
//
//@DisplayName("Book DAO test")
//@JdbcTest
//@Import(BookDaoImpl.class)
//class BookDaoImplTest {
//
//  @Autowired
//  private BookDaoImpl dao;
//
//  private Author author = new Author(100L, "AuthorTest");
//  private Genre genre = new Genre(100L, "GenreTest");
//
//  @Test
//  void getById() {
//    Book result = dao.getById(100);
//    Assertions.assertNotNull(result);
//  }
//
//  @Test
//  void save() {
//    String bookName = "Test";
//    Book book = Book.builder()
//        .name(bookName)
//        .author(author)
//        .genre(genre)
//        .build();
//
//    dao.save(book);
//    Book result = dao.getById(1);
//    Assertions.assertNotNull(result);
//    Assertions.assertEquals(bookName, result.getName());
//  }
//
//  @Test
//  void update() {
//    long bookId = 100L;
//    String bookName = "Test";
//    Book book = Book.builder()
//        .id(bookId)
//        .name(bookName)
//        .author(author)
//        .genre(genre)
//        .build();
//
//    dao.update(book);
//    Book result = dao.getById(bookId);
//    Assertions.assertNotNull(result);
//    Assertions.assertEquals(bookName, result.getName());
//  }
//
//  @Test
//  void delete() {
//    long bookId = 100L;
//
//    dao.delete(bookId);
//    Book result = dao.getById(bookId);
//    Assertions.assertNull(result);
//  }
//}
