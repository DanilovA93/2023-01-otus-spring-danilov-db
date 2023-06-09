package ru.otus.library.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Document("comments")
public class Comment {

  @Id
  private String id;

  private String text;

  @DBRef(lazy = true)
  @Exclude
  private Book book;

  public Comment(String text, Book book) {
    this.text = text;
    this.book = book;
  }
}
