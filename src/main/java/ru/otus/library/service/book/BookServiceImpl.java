package ru.otus.library.service.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.library.dao.book.BookDao;
import ru.otus.library.entity.Book;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

  private final BookDao bookDao;

  @Override
  public void save(Book book) {
    bookDao.save(book);
  }

  @Override
  public Book getById(Long id) {
    return bookDao.getById(id);
  }

  @Override
  public void update(Book book) {
    bookDao.update(book);
  }

  @Override
  public void delete(Long id) {
    bookDao.delete(id);
  }
}
