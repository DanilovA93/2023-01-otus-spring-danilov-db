package ru.otus.library.repository.comment;

import javax.persistence.EntityManager;
import org.springframework.stereotype.Component;
import ru.otus.library.entity.Comment;

@Component
public class CommentRepositoryImpl implements CommentRepository {

  private final EntityManager em;

  public CommentRepositoryImpl(EntityManager em) {
    this.em = em;
  }

  @Override
  public void save(Comment comment) {
    em.persist(comment);
  }

  @Override
  public Comment findById(long id) {
    return em.find(Comment.class, id);
  }

  @Override
  public Comment update(Comment comment) {
    return em.merge(comment);
  }

  @Override
  public void deleteById(Long id) {
    Comment comment = findById(id);
    em.remove(comment);
  }
}
