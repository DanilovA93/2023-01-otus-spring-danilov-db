package ru.otus.library.dto;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.otus.library.entity.Author;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AuthorDTO {

  private Long id;
  private String name;
  private List<BookDTO> books;

  public static AuthorDTO mapToSimple(Author author) {
    return AuthorDTO.builder()
        .id(author.getId())
        .name(author.getName())
        .build();
  }

  public static AuthorDTO mapToFull(Author author) {
    return AuthorDTO.builder()
        .id(author.getId())
        .name(author.getName())
        .books(author.getBooks().stream()
            .map(BookDTO::mapToSimple)
            .collect(Collectors.toList()))
        .build();
  }

  @Override
  public String toString() {
    return "AuthorDTO{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ((books != null) ? ", books=" + books : "") +
        '}';
  }
}
