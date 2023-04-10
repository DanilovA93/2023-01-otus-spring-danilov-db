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
import ru.otus.library.repository.BookRepository;
import ru.otus.library.service.author.AuthorService;
import ru.otus.library.service.genre.GenreService;

@Component
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

  private final AuthorService authorService;
  private final GenreService genreService;
  private final BookRepository bookRepository;

  @Override
  @Transactional
  public void create(Long authorId, Long genreId, String name) {
    Author author = authorService.getById(authorId);
    Genre genre = genreService.getById(genreId);
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
    return BookMapper.map(getById(id));
  }

  @Override
  public Book getById(Long id) {
    return bookRepository
        .findById(id)
        .orElseThrow(() -> new RuntimeException("Book with id " + id + "  not found"));
  }

  @Override
  @Transactional
  public void update(Long id, Long authorId, Long genreId, String name) {
    Author author = authorService.getById(authorId);
    Genre genre = genreService.getById(genreId);
    Book book = getById(id);
    book.setAuthor(author);
    book.setGenre(genre);
    book.setName(name);

    bookRepository.save(book);
  }

  @Override
  public void delete(Long id) {
    bookRepository.deleteById(id);
  }
}
