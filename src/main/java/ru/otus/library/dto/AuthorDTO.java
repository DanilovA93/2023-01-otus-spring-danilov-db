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
public class AuthorDTO {

  private String id;
  private String name;

  @Override
  public String toString() {
    return "AuthorDTO{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
