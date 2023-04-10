package ru.otus.library.service.comment;

import java.util.List;
import ru.otus.library.dto.CommentDTO;
import ru.otus.library.entity.Comment;

public interface CommentService {
  void create(Long bookId, String text);
  List<CommentDTO> findAllByBookId(Long bookId);
  CommentDTO findById(Long id);
  Comment getById(Long id);
  void update(Long id, String text);
  void delete(Long id);
}
