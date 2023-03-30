package ru.otus.library.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.otus.library.entity.Comment;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CommentDTO {

  private Long id;
  private String text;
  private BookDTO book;

  public static CommentDTO mapToSimple(Comment comment) {
    return CommentDTO.builder()
        .id(comment.getId())
        .text(comment.getText())
        .build();
  }

  public static CommentDTO mapToFull(Comment comment) {
    return CommentDTO.builder()
        .id(comment.getId())
        .text(comment.getText())
        .book(BookDTO.mapToSimple(comment.getBook()))
        .build();
  }

  @Override
  public String toString() {
    return "CommentDTO{" +
        "id=" + id +
        ", text='" + text + '\'' +
        ((book != null) ? ", book=" + book : "") +
        '}';
  }
}
