package ru.otus.library.service.comment;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.library.dto.CommentDTO;
import ru.otus.library.mapper.CommentMapper;
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
  @Transactional
  public List<CommentDTO> findAllByBookId(Long bookId) {
    Book book = bookRepository.findById(bookId);
    return book.getComments().stream()
        .map(CommentMapper::map)
        .collect(Collectors.toList());
  }

  @Override
  public CommentDTO findById(Long id) {
    return CommentMapper.map(commentRepository.findById(id));
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
