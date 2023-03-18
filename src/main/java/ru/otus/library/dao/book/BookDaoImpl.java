package ru.otus.library.dao.book;

import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.otus.library.entity.Book;
import ru.otus.library.mapper.BookMapper;

@Repository
@RequiredArgsConstructor
public class BookDaoImpl implements BookDao {

  private final static String INSERT_QUERY = "insert into books (name, author_id, genre_id) values (:name, :authorId, :genreId)";
  private final static String SELECT_QUERY = ""
      + " select b.id id, b.name name, a.id a_id, a.name a_name, g.id g_id, g.name g_name from books b "
      + " join authors a on a.id = b.author_id "
      + " join genres g on g.id = b.genre_id "
      + " where b.id = :id ";
  private final static String UPDATE_QUERY = "update books set name = :name, author_id = :authorId, genre_id = :genreId where id = :id";
  private final static String DELETE_QUERY = "delete from books where id = :id";

  private final NamedParameterJdbcTemplate jdbc;

  @Override
  public void save(Book book) {
    Map<String, Object> params = Map.of(
        "name", book.getName(),
        "authorId", book.getAuthor().getId(),
        "genreId", book.getGenre().getId()
    );
    jdbc.update(INSERT_QUERY, params);
  }

  @Override
  public Book getById(long id) {
    Map<String, Object> params = Map.of("id", id);
    return jdbc.queryForObject(SELECT_QUERY, params, new BookMapper());
  }

  @Override
  public void update(Book book) {
    Map<String, Object> params = Map.of(
        "id", book.getId(),
        "name", book.getName(),
        "authorId", book.getAuthor().getId(),
        "genreId", book.getGenre().getId()
    );
    jdbc.update(UPDATE_QUERY, params);
  }

  @Override
  public void delete(Long id) {
    Map<String, Object> params = Map.of("id", id);
    jdbc.update(DELETE_QUERY, params);
  }
}
