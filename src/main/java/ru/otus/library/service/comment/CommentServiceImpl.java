package ru.otus.library.service.comment;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.library.repository.book.BookRepository;
import ru.otus.library.repository.comment.CommentRepository;
import ru.otus.library.entity.Book;
import ru.otus.library.entity.Comment;

@Component
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

  private final CommentRepository commentRepository;
  private final BookRepository bookRepository;

  @Override
  @Transactional
  public void create(Long bookId, String text) {
    Book book = bookRepository.findById(bookId);
    Comment comment = Comment.builder()
        .book(book)
        .text(text)
        .build();

    commentRepository.save(comment);
  }

  @Override
  public List<Comment> findAllByBookId(Long bookId) {
    Book book = bookRepository.findById(bookId);
    return book.getComments();
  }

  @Override
  public Comment findById(Long id) {
    return commentRepository.findById(id);
  }

  @Override
  @Transactional
  public void update(Long id, String text) {
    Comment comment = commentRepository.findById(id);
    comment.setText(text);

    commentRepository.update(comment);
  }

  @Override
  @Transactional
  public void delete(Long id) {
    commentRepository.deleteById(id);
  }
}
