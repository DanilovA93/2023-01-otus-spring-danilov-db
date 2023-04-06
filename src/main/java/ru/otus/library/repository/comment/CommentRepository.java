package ru.otus.library.repository.comment;

import ru.otus.library.entity.Comment;

public interface CommentRepository {
  void save(Comment o);
  Comment findById(long id);
  Comment update(Comment o);
  void deleteById(Long id);
}
