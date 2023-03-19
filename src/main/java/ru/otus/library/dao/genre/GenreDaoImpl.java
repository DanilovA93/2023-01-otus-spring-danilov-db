package ru.otus.library.dao.genre;

import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.otus.library.entity.Genre;

@Repository
@RequiredArgsConstructor
public class GenreDaoImpl implements GenreDao {

  private final static String INSERT_QUERY = "insert into genres (name) values (:name)";
  private final static String SELECT_QUERY = "select id, name from genres where id = :id";
  private final static String UPDATE_QUERY = "update genres set name = :name where id = :id";
  private final static String DELETE_QUERY = "delete from genres where id = :id";

  private final NamedParameterJdbcTemplate jdbc;

  @Override
  public void save(Genre genre) {
    Map<String, Object> params = Map.of("name", genre.getName());
    jdbc.update(INSERT_QUERY, params);
  }

  @Override
  public Genre getById(long id) {
    try {
      Map<String, Object> params = Map.of("id", id);
      BeanPropertyRowMapper<Genre> rowMapper = BeanPropertyRowMapper.newInstance(Genre.class);
      return jdbc.queryForObject(SELECT_QUERY, params, rowMapper);

    } catch (EmptyResultDataAccessException e) {
      return null;
    }
  }

  @Override
  public void update(Genre genre) {
    Map<String, Object> params = Map.of(
        "id", genre.getId(),
        "name", genre.getName()
    );
    jdbc.update(UPDATE_QUERY, params);
  }

  @Override
  public void delete(Long id) {
    Map<String, Object> params = Map.of("id", id);
    jdbc.update(DELETE_QUERY, params);
  }
}
