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
public class GenreDTO {

  private Long id;
  private String name;

  @Override
  public String toString() {
    return "GenreDTO{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
