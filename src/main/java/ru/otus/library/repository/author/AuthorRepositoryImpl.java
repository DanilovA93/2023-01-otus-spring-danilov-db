package ru.otus.library.repository.author;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import ru.otus.library.entity.Author;

@Component
public class AuthorRepositoryImpl implements AuthorRepository {

  @PersistenceContext
  private final EntityManager em;

  public AuthorRepositoryImpl(EntityManager em) {
    this.em = em;
  }

  @Override
  public void save(Author author) {
    em.persist(author);
  }

  @Override
  public List<Author> findAll() {
    return em.createQuery("select a from Author a").getResultList();
  }

  @Override
  public Author findById(long id) {
    return em.find(Author.class, id);
  }

  @Override
  public Author update(Author author) {
    return em.merge(author);
  }

  @Override
  public void delete(Long id) {
    Author author = findById(id);
    em.remove(author);
  }
}
