package ru.otus.library.repository.comment;

import java.util.List;
import ru.otus.library.entity.Comment;

public interface CommentRepository {
  void save(Comment o);
  List<Comment> findAllByBookId(Long bookId);
  Comment getById(long id);
  Comment update(Comment o);
  void deleteById(Long id);
}
