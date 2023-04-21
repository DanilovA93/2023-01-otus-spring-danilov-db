package ru.otus.library.shell;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.library.dto.CommentDTO;
import ru.otus.library.service.comment.CommentService;

@ShellComponent
@RequiredArgsConstructor
public class CommentShell {

  private final CommentService commentService;

  @ShellMethod(
      key = {"cc", "comment-create"},
      value = "Create a comment"
  )
  public void create(
      @ShellOption({"book-id", "bid"}) String bookId,
      @ShellOption({"text", "t"}) String text
  ){
    commentService.create(bookId, text);
  }

  @ShellMethod(
      key = {"cra", "comment-read-all"},
      value = "Read all comment for book"
  )
  public List<CommentDTO> findAllByBookId(
      @ShellOption({"book-id", "bid"}) String bookId
  ){
    return commentService.findAllByBookId(bookId);
  }

  @ShellMethod(
      key = {"cr", "comment-read"},
      value = "Read a comment"
  )
  public CommentDTO findById(
      @ShellOption({"id", "id"}) String id
  ){
    return commentService.findById(id);
  }

  @ShellMethod(
      key = {"cu", "comment-update"},
      value = "Update the comment"
  )
  public void update(
      @ShellOption({"id", "id"}) String id,
      @ShellOption({"text", "text"}) String text
  ){
    commentService.update(id, text);
  }

  @ShellMethod(
      key = {"cd", "comment-delete"},
      value = "Delete the comment"
  )
  public void delete(
      @ShellOption({"id", "id"}) String id
  ){
    commentService.delete(id);
  }
}
