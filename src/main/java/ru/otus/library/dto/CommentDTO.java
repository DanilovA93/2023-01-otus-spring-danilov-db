package ru.otus.library.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CommentDTO {

  private String id;
  private String text;

  @Override
  public String toString() {
    return "CommentDTO{" +
        "id=" + id +
        ", text='" + text + '\'' +
        '}';
  }
}
