package ru.otus.library.dao.author;

import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.otus.library.entity.Author;

@Repository
@RequiredArgsConstructor
public class AuthorDaoImpl implements AuthorDao {

  private final static String INSERT_QUERY = "insert into authors (name) values (:name)";
  private final static String SELECT_QUERY = "select id, name from authors where id = :id";
  private final static String UPDATE_QUERY = "update authors set name = :name where id = :id";
  private final static String DELETE_QUERY = "delete from authors where id = :id";

  private final NamedParameterJdbcTemplate jdbc;

  @Override
  public void save(Author author) {
    Map<String, Object> params = Map.of("name", author.getName());
    jdbc.update(INSERT_QUERY, params);
  }

  @Override
  public Author getById (long id) {
    try {
      Map<String, Object> params = Map.of("id", id);
      BeanPropertyRowMapper<Author> rowMapper = BeanPropertyRowMapper.newInstance(Author.class);
      return jdbc.queryForObject(SELECT_QUERY, params, rowMapper);

    } catch (EmptyResultDataAccessException e) {
      return null;
    }
  }

  @Override
  public void update(Author author) {
    Map<String, Object> params = Map.of(
        "id", author.getId(),
        "name", author.getName()
    );
    jdbc.update(UPDATE_QUERY, params);
  }

  @Override
  public void delete(Long id) {
    Map<String, Object> params = Map.of("id", id);
    jdbc.update(DELETE_QUERY, params);
  }
}
