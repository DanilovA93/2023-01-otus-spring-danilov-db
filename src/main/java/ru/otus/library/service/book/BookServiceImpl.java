package ru.otus.library.service.book;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.library.dto.BookDTO;
import ru.otus.library.entity.Author;
import ru.otus.library.entity.Book;
import ru.otus.library.entity.Genre;
import ru.otus.library.mapper.BookMapper;
import ru.otus.library.repository.author.AuthorRepository;
import ru.otus.library.repository.book.BookRepository;
import ru.otus.library.repository.genre.GenreRepository;

@Component
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;
  private final AuthorRepository authorRepository;
  private final GenreRepository genreRepository;

  @Override
  @Transactional
  public void create(Long authorId, Long genreId, String name) {
    Author author = authorRepository.findById(authorId);
    Genre genre = genreRepository.findById(genreId);
    Book book = Book.builder()
        .name(name)
        .author(author)
        .genre(genre)
        .build();

    bookRepository.save(book);
  }

  @Override
  public List<BookDTO> findAll() {
    return bookRepository.findAll().stream()
        .map(BookMapper::map)
        .collect(Collectors.toList());
  }

  @Override
  public BookDTO findById(Long id) {
    return BookMapper.map(bookRepository.findById(id));
  }

  @Override
  @Transactional
  public void update(Long id, Long authorId, Long genreId, String name) {
    Author author = authorRepository.findById(authorId);
    Genre genre = genreRepository.findById(genreId);
    Book book = bookRepository.findById(id);
    book.setAuthor(author);
    book.setGenre(genre);
    book.setName(name);

    bookRepository.update(book);
  }

  @Override
  @Transactional
  public void delete(Long id) {
    bookRepository.delete(id);
  }
}
