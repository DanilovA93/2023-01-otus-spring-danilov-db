package ru.otus.library.dto;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.otus.library.entity.Book;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BookDTO {

  private Long id;
  private String name;
  private AuthorDTO author;
  private GenreDTO genre;
  private List<CommentDTO> comments;

  public static BookDTO mapToSimple(Book book) {
    return BookDTO.builder()
        .id(book.getId())
        .name(book.getName())
        .build();
  }

  public static BookDTO mapToFull(Book book) {
    return BookDTO.builder()
        .id(book.getId())
        .name(book.getName())
        .author(AuthorDTO.mapToSimple(book.getAuthor()))
        .genre(GenreDTO.mapToSimple(book.getGenre()))
        .comments(book.getComments().stream()
            .map(CommentDTO::mapToSimple)
            .collect(Collectors.toList()))
        .build();
  }

  @Override
  public String toString() {
    return "BookDTO{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ((author != null) ? ", author=" + author : "") +
        ((genre != null) ? ", genre=" + genre : "") +
        ((comments != null) ? ", comments=" + comments : "") +
        '}';
  }
}
