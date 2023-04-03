package ru.otus.library.repository.genre;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import ru.otus.library.entity.Genre;

@Component
public class GenreRepositoryImpl implements GenreRepository {

  @PersistenceContext
  private final EntityManager em;

  public GenreRepositoryImpl(EntityManager em) {
    this.em = em;
  }

  @Override
  public void save(Genre genre) {
    em.persist(genre);
  }

  @Override
  public List<Genre> findAll() {
    return em.createQuery("select a from Genre a").getResultList();
  }

  @Override
  public Genre findById(long id) {
    return em.find(Genre.class, id);
  }

  @Override
  public Genre update(Genre genre) {
    return em.merge(genre);
  }

  @Override
  public void delete(Long id) {
    Genre genre = findById(id);
    em.remove(genre);
  }
}
