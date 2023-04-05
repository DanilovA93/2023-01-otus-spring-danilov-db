package ru.otus.library.mapper;

import ru.otus.library.dto.BookDTO;
import ru.otus.library.entity.Book;

public class BookMapper {

  public static BookDTO map(Book book) {
    return BookDTO.builder()
        .id(book.getId())
        .name(book.getName())
        .build();
  }
}
