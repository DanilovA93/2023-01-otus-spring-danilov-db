package ru.otus.library.mapper;

import ru.otus.library.dto.AuthorDTO;
import ru.otus.library.entity.Author;

public class AuthorMapper {

  public static AuthorDTO map(Author author) {
    return AuthorDTO.builder()
        .id(author.getId())
        .name(author.getName())
        .build();
  }
}
