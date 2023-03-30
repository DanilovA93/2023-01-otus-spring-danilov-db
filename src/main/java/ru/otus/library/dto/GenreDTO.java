package ru.otus.library.dto;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.otus.library.entity.Genre;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class GenreDTO {

  private Long id;
  private String name;
  private List<BookDTO> books;

  public static GenreDTO mapToSimple(Genre genre) {
    return GenreDTO.builder()
        .id(genre.getId())
        .name(genre.getName())
        .build();
  }

  public static GenreDTO mapToFull(Genre genre) {
    return GenreDTO.builder()
        .id(genre.getId())
        .name(genre.getName())
        .books(genre.getBooks().stream()
            .map(BookDTO::mapToSimple)
            .collect(Collectors.toList()))
        .build();
  }

  @Override
  public String toString() {
    return "GenreDTO{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ((books != null) ? ", books=" + books : "") +
        '}';
  }
}
