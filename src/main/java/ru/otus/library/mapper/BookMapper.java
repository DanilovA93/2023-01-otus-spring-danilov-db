package ru.otus.library.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import ru.otus.library.entity.Author;
import ru.otus.library.entity.Book;
import ru.otus.library.entity.Genre;

public class BookMapper implements RowMapper<Book> {

  @Override
  public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
    Long id = rs.getLong("id");
    String name = rs.getString("name");
    Author author = new Author(
        rs.getLong("a_id"),
        rs.getString("a_name")
    );
    Genre genre = new Genre(
        rs.getLong("g_id"),
        rs.getString("g_name")
    );

    return new Book(id, name, author, genre);
  }
}
