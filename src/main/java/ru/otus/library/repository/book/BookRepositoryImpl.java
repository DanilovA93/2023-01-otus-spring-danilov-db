package ru.otus.library.repository.book;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import ru.otus.library.entity.Book;

@Component
public class BookRepositoryImpl implements BookRepository {

  @PersistenceContext
  private final EntityManager em;

  public BookRepositoryImpl(EntityManager em) {
    this.em = em;
  }

  @Override
  public void save(Book book) {
    em.persist(book);
  }

  @Override
  public List<Book> findAll() {
    return em.createQuery("select a from Book a").getResultList();
  }

  @Override
  public Book findById(long id) {
    return em.find(Book.class, id);
  }

  @Override
  public Book update(Book book) {
    return em.merge(book);
  }

  @Override
  public void delete(Long id) {
    Book book = findById(id);
    em.remove(book);
  }
}
