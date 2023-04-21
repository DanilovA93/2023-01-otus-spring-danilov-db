package ru.otus.library.service.comment;

import java.util.List;
import ru.otus.library.dto.CommentDTO;
import ru.otus.library.entity.Comment;

public interface CommentService {
  void create(String bookId, String text);
  List<CommentDTO> findAllByBookId(String bookId);
  CommentDTO findById(String id);
  Comment getById(String id);
  void update(String id, String text);
  void delete(String id);
}
