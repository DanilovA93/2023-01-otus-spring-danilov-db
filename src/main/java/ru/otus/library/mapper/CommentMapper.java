package ru.otus.library.mapper;

import ru.otus.library.dto.CommentDTO;
import ru.otus.library.entity.Comment;

public class CommentMapper {

  public static CommentDTO map(Comment comment) {
    return CommentDTO.builder()
        .id(comment.getId())
        .text(comment.getText())
        .build();
  }
}
