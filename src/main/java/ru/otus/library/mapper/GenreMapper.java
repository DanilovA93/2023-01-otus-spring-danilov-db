package ru.otus.library.mapper;

import ru.otus.library.dto.GenreDTO;
import ru.otus.library.entity.Genre;

public class GenreMapper {

  public static GenreDTO map(Genre genre) {
    return GenreDTO.builder()
        .id(genre.getId())
        .name(genre.getName())
        .build();
  }
}
