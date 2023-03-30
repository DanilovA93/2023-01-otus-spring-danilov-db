package ru.otus.library.repository.comment;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import ru.otus.library.entity.Comment;

@Repository
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
  public List<Comment> findAllByBookId(Long bookId) {
    Query query = em.createQuery("select c from Comment c where book_id = :bookId");
    query.setParameter("bookId", bookId);

    return query.getResultList();
  }

  @Override
  public Comment getById(long id) {
    return em.find(Comment.class, id);
  }

  @Override
  public Comment update(Comment comment) {
    return em.merge(comment);
  }

  @Override
  public void deleteById(Long id) {
    Query query = em.createQuery("delete from Comment where id = :id");
    query.setParameter("id", id);

    query.executeUpdate();
  }
}
