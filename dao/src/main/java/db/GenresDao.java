package db;

import connection.ConnectionManager;
import entity.Genres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vinty on 09.04.2017.
 */
public class GenresDao {

    private static final String GENRES_TABLE_NAME = "genres";
    private static final Object LOCK = new Object();
    private static GenresDao INSTANCE = null;

    public static GenresDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new GenresDao();
                }
            }
        }
        return INSTANCE;
    }

    private Genres createGenresFromResultSet(ResultSet resultSet) throws SQLException {
        return new Genres(
                resultSet.getLong(GENRES_TABLE_NAME + ".id"),
                resultSet.getString(GENRES_TABLE_NAME + ".name"));
    }

    public List<Genres> findAll() {
        List<Genres> genres = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM genre ORDER BY name;")) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        genres.add(createGenresFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genres;
    }
}
