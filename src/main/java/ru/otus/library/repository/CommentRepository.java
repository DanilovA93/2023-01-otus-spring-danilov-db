package ru.otus.library.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.library.entity.Comment;

public interface CommentRepository extends MongoRepository<Comment, String> {
  List<Comment> findAllByBookId(String bookId);
}
