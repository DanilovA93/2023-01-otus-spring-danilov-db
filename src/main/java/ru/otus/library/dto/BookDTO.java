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

  private String id;
  private String name;

  @Override
  public String toString() {
    return "BookDTO{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
