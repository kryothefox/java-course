package com.gregor.videogameapi.dto;

//import java.sql.*;
//import java.util.*;
import com.gregor.videogameapi.entity.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.List;

public class GameDataImporter {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/videogames";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "admin@1234";

    public void insertData() throws Exception {
        RawgClient client = new RawgClient();
        ResponseContext context = client.getGames(RawgClient.BASE_URI);
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            while (context != null && context.getNext() != null) {
                insertGames(conn, context.getResults());
                context = client.getGames(context.getNext());
            }
        }
    }

    private static void insertGames(Connection conn, List<Game> games) throws SQLException {
        String insertGameSql = "INSERT IGNORE INTO games (id, slug, name, released, tba, background_image, rating, rating_top, ratings_count, reviews_text_count, added, metacritic, playtime, suggestions_count, updated, reviews_count, saturated_color, dominant_color, esrb_rating_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        conn.setAutoCommit(false);
        int count = 0;
        try (PreparedStatement stmt = conn.prepareStatement(insertGameSql)) {
            for (Game game : games) {
                try {
                    if (game.getEsrbRating() != null) {
                        insertEsrbRating(conn, game.getEsrbRating());
                    }
                    stmt.setInt(1, game.getId());
                    stmt.setString(2, game.getSlug());
                    stmt.setString(3, game.getName());
                    stmt.setDate(4, game.getReleased() != null ? java.sql.Date.valueOf(game.getReleased()) : null);
                    stmt.setBoolean(5, game.isTba());
                    stmt.setString(6, game.getBackgroundImage());
                    stmt.setDouble(7, game.getRating());
                    stmt.setInt(8, game.getRatingTop());
                    stmt.setInt(9, game.getRatingsCount());
                    stmt.setInt(10, game.getReviewsTextCount());
                    stmt.setInt(11, game.getAdded());
                    stmt.setObject(12, game.getMetacritic(), Types.INTEGER);
                    stmt.setInt(13, game.getPlaytime());
                    stmt.setInt(14, game.getSuggestionsCount());
                    stmt.setTimestamp(15, Timestamp.valueOf(game.getUpdated().replace("T", " ").replace("Z", "")));
                    stmt.setInt(16, game.getReviewsCount());
                    stmt.setString(17, game.getSaturatedColor());
                    stmt.setString(18, game.getDominantColor());
                    stmt.setObject(19, game.getEsrbRating()!=null?game.getEsrbRating().getId():null, Types.INTEGER);
                    if (game.getAddedByStatus() != null) {
                        insertAddedByStatus(conn, game.getId(), game.getAddedByStatus());
                    }
                    insertRatings(conn, game.getId(), game.getRatings());
                    insertGenres(conn, game.getId(), game.getGenres());
                    insertTags(conn, game.getId(), game.getTags());
                    insertStores(conn, game.getId(), game.getStores());
                    insertScreenshots(conn, game.getId(), game.getShortScreenshots());
                    insertParentPlatforms(conn, game.getId(), game.getParentPlatforms());
                    insertPlatforms(conn, game.getId(), game.getPlatforms());

                    stmt.addBatch();

                    count++;

                    if (count % games.size() == 0) {
                        stmt.executeBatch();
                        conn.commit();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    conn.rollback();
                }
            }

        }

    }

    // Métodos auxiliares insertEsrbRating, insertRatings, insertAddedByStatus, etc., se definen aquí...
    // Cada uno se encarga de insertar su entidad si no existe y de registrar las relaciones.
    private static void insertEsrbRating(Connection conn, EsrbRating rating) throws SQLException {
        String sql = "INSERT IGNORE INTO esrb_ratings (id, name, slug) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, rating.getId());
            stmt.setString(2, rating.getName());
            stmt.setString(3, rating.getSlug());
            stmt.executeUpdate();
        }
    }

    private static void insertAddedByStatus(Connection conn, int gameId, AddedByStatus status) throws SQLException {
        String sql = "INSERT IGNORE INTO added_by_status (game_id, yet, owned, beaten, toplay, dropped, playing) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, gameId);
            stmt.setInt(2, status.getYet());
            stmt.setInt(3, status.getOwned());
            stmt.setInt(4, status.getBeaten());
            stmt.setInt(5, status.getToplay());
            stmt.setInt(6, status.getDropped());
            stmt.setInt(7, status.getPlaying());
            stmt.executeUpdate();
        }
    }

    private static void insertRatings(Connection conn, int gameId, List<Rating> ratings) throws SQLException {
        String sql = "INSERT IGNORE INTO ratings (id, game_id, title, count, percent) VALUES (?, ?, ?, ?, ?)";
        for (Rating rating : ratings) {
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, rating.getId());
                stmt.setInt(2, gameId);
                stmt.setString(3, rating.getTitle());
                stmt.setInt(4, rating.getCount());
                stmt.setDouble(5, rating.getPercent());
                stmt.executeUpdate();
            }
        }
    }

    private static void insertGenres(Connection conn, int gameId, List<Genre> genres) throws SQLException {
        String genreSql = "INSERT IGNORE INTO genres (id, name, slug, games_count, image_background) VALUES (?, ?, ?, ?, ?)";
        String relSql = "INSERT IGNORE INTO game_genres (game_id, genre_id) VALUES (?, ?)";
        for (Genre genre : genres) {
            try (PreparedStatement stmt = conn.prepareStatement(genreSql)) {
                stmt.setInt(1, genre.getId());
                stmt.setString(2, genre.getName());
                stmt.setString(3, genre.getSlug());
                stmt.setInt(4, genre.getGamesCount());
                stmt.setString(5, genre.getImageBackground());
                stmt.executeUpdate();
            }
            try (PreparedStatement stmt = conn.prepareStatement(relSql)) {
                stmt.setInt(1, gameId);
                stmt.setInt(2, genre.getId());
                stmt.executeUpdate();
            }
        }
    }

    private static void insertTags(Connection conn, int gameId, List<Tag> tags) throws SQLException {
        String tagSql = "INSERT IGNORE INTO tags (id, name, slug, language, games_count, image_background) VALUES (?, ?, ?, ?, ?, ?)";
        String relSql = "INSERT IGNORE INTO game_tags (game_id, tag_id) VALUES (?, ?)";
        for (Tag tag : tags) {
            try (PreparedStatement stmt = conn.prepareStatement(tagSql)) {
                stmt.setInt(1, tag.getId());
                stmt.setString(2, tag.getName());
                stmt.setString(3, tag.getSlug());
                stmt.setString(4, tag.getLanguage());
                stmt.setInt(5, tag.getGamesCount());
                stmt.setString(6, tag.getImageBackground());
                stmt.executeUpdate();
            }
            try (PreparedStatement stmt = conn.prepareStatement(relSql)) {
                stmt.setInt(1, gameId);
                stmt.setInt(2, tag.getId());
                stmt.executeUpdate();
            }
        }
    }

    private static void insertStores(Connection conn, int gameId, List<StoreWrapper> stores) throws SQLException {
        String storeSql = "INSERT IGNORE INTO stores (id, name, slug, domain, games_count, image_background) VALUES (?, ?, ?, ?, ?, ?)";
        String relSql = "INSERT IGNORE INTO game_stores (game_id, store_id) VALUES (?, ?)";
        for (StoreWrapper wrapper : stores) {
            Store store = wrapper.getStore();
            try (PreparedStatement stmt = conn.prepareStatement(storeSql)) {
                stmt.setInt(1, store.getId());
                stmt.setString(2, store.getName());
                stmt.setString(3, store.getSlug());
                stmt.setString(4, store.getDomain());
                stmt.setInt(5, store.getGamesCount());
                stmt.setString(6, store.getImageBackground());
                stmt.executeUpdate();
            }
            try (PreparedStatement stmt = conn.prepareStatement(relSql)) {
                stmt.setInt(1, gameId);
                stmt.setInt(2, store.getId());
                stmt.executeUpdate();
            }
        }
    }

    private static void insertScreenshots(Connection conn, int gameId, List<ShortScreenshot> screenshots) throws SQLException {
        String sql = "INSERT IGNORE INTO screenshots (id, game_id, image) VALUES (?, ?, ?)";
        for (ShortScreenshot s : screenshots) {
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, s.getId());
                stmt.setInt(2, gameId);
                stmt.setString(3, s.getImage());
                stmt.executeUpdate();
            }
        }
    }

    private static void insertParentPlatforms(Connection conn, int gameId, List<ParentPlatformWrapper> platforms) throws SQLException {
        String ppSql = "INSERT IGNORE INTO parent_platforms (id, name, slug) VALUES (?, ?, ?)";
        String relSql = "INSERT IGNORE INTO game_parent_platforms (game_id, parent_platform_id) VALUES (?, ?)";
        for (ParentPlatformWrapper wrapper : platforms) {
            ParentPlatform platform = wrapper.getPlatform();
            try (PreparedStatement stmt = conn.prepareStatement(ppSql)) {
                stmt.setInt(1, platform.getId());
                stmt.setString(2, platform.getName());
                stmt.setString(3, platform.getSlug());
                stmt.executeUpdate();
            }
            try (PreparedStatement stmt = conn.prepareStatement(relSql)) {
                stmt.setInt(1, gameId);
                stmt.setInt(2, platform.getId());
                stmt.executeUpdate();
            }
        }
    }

    private static void insertPlatforms(Connection conn, int gameId, List<PlatformWrapper> wrappers) throws SQLException {
        String platformSql = "INSERT IGNORE INTO platforms (id, name, slug, image, year_start, year_end, games_count, image_background) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        String relSql = "INSERT IGNORE INTO game_platforms (game_id, platform_id, released_at) VALUES (?, ?, ?)";
        for (PlatformWrapper w : wrappers) {
            Platform p = w.getPlatform();
            try (PreparedStatement stmt = conn.prepareStatement(platformSql)) {
                stmt.setInt(1, p.getId());
                stmt.setString(2, p.getName());
                stmt.setString(3, p.getSlug());
                stmt.setString(4, p.getImage());
                stmt.setObject(5, p.getYearStart(), Types.INTEGER);
                stmt.setObject(6, p.getYearEnd(), Types.INTEGER);
                stmt.setInt(7, p.getGamesCount());
                stmt.setString(8, p.getImageBackground());
                stmt.executeUpdate();
            }
            try (PreparedStatement stmt = conn.prepareStatement(relSql)) {
                stmt.setInt(1, gameId);
                stmt.setInt(2, p.getId());
                stmt.setDate(3, w.getReleasedAt() != null ? Date.valueOf(w.getReleasedAt()) : null);
                stmt.executeUpdate();
            }
        }
    }

}
