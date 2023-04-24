package ru.otus.library.mongock.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;
import java.util.List;
import ru.otus.library.entity.Author;
import ru.otus.library.entity.Book;
import ru.otus.library.entity.Comment;
import ru.otus.library.entity.Genre;
import ru.otus.library.repository.AuthorRepository;
import ru.otus.library.repository.BookRepository;
import ru.otus.library.repository.CommentRepository;
import ru.otus.library.repository.GenreRepository;

@ChangeLog
public class DataBaseChangelog {

  private Author author;
  private Genre genre;
  private Book book;

  @ChangeSet(order = "001", id = "dropDb", author = "andanilov", runAlways = true)
  public void dropDb(MongoDatabase db) {
    db.drop();
  }

  @ChangeSet(order = "002", id = "insertAuthors", author = "andanilov", runAlways = true)
  public void insertAuthors(AuthorRepository repository) {
    author = repository.save(new Author("Alexander Pushkin"));
  }

  @ChangeSet(order = "003", id = "insertGenres", author = "andanilov", runAlways = true)
  public void insertGenres(GenreRepository repository) {
    genre = repository.save(new Genre("Roman"));
  }

  @ChangeSet(order = "004", id = "insertBooks", author = "andanilov", runAlways = true)
  public void insertBooks(BookRepository repository) {
    book = repository.save(
        Book.builder()
            .author(author)
            .genre(genre)
            .name("Dubrovsky")
            .build()
    );
  }

  @ChangeSet(order = "005", id = "insertComments", author = "andanilov", runAlways = true)
  public void insertComments(CommentRepository commentRepository, BookRepository bookRepository) {
    book.setComments(
        List.of(
            commentRepository.save(new Comment("comment 1", book)),
            commentRepository.save(new Comment("comment 2", book)),
            commentRepository.save(new Comment("comment 3", book))
        )
    );
    bookRepository.save(book);
  }
}
