package ru.otus.library.service.comment;

import java.util.List;
import ru.otus.library.entity.Comment;

public interface CommentService {
  void create(Long bookId, String text);
  List<Comment> findAllByBookId(Long bookId);
  Comment findById(Long id);
  void update(Long id, String text);
  void delete(Long id);
}
