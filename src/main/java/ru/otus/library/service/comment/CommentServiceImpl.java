package ru.otus.library.service.comment;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.library.dto.CommentDTO;
import ru.otus.library.entity.Book;
import ru.otus.library.entity.Comment;
import ru.otus.library.mapper.CommentMapper;
import ru.otus.library.repository.CommentRepository;
import ru.otus.library.service.book.BookService;

@Component
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

  private final BookService bookService;
  private final CommentRepository commentRepository;

  @Override
  @Transactional
  public void create(Long bookId, String text) {
    Book book = bookService.getById(bookId);
    Comment comment = Comment.builder()
        .book(book)
        .text(text)
        .build();

    commentRepository.save(comment);
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommentDTO> findAllByBookId(Long bookId) {
    return commentRepository.findAllByBookId(bookId).stream()
        .map(CommentMapper::map)
        .collect(Collectors.toList());
  }

  @Override
  public CommentDTO findById(Long id) {
    return CommentMapper.map(getById(id));
  }

  @Override
  public Comment getById(Long id) {
    return commentRepository
        .findById(id)
        .orElseThrow(() -> new RuntimeException("Comment with id " + id + "  not found"));
  }

  @Override
  @Transactional
  public void update(Long id, String text) {
    Comment comment = getById(id);
    comment.setText(text);

    commentRepository.save(comment);
  }

  @Override
  public void delete(Long id) {
    commentRepository.deleteById(id);
  }
}
