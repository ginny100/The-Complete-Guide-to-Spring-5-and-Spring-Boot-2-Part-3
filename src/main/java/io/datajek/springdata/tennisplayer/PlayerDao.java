package io.datajek.springdata.tennisplayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.sql.Timestamp;

@Repository
public class PlayerDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * Get info of all players
     * @return a list of Player objects
     */
    public List<Player> getAllPlayers() {
        String sql = "SELECT * FROM PLAYER";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Player>(Player.class));
    }

    /**
     * Find the Player with the given id
     * @param id
     * @return a Player object
     */
    public Player getPlayerById(int id) {
        String sql = "SELECT * FROM PLAYER WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql,
                new BeanPropertyRowMapper<Player>(Player.class),
                new Object[] {id});
    }

    /**
     * Insert new player into the Player table
     * @param player
     * @return the number of affected rows in the table
     */
    public int insertPlayer(Player player) {
        String sql = "INSERT INTO PLAYER (ID, Name, Nationality, Birth_date, Titles) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, new Object[] {player.getId(), player.getName(), player.getNationality(),
                new Timestamp(player.getBirthDate().getTime()), player.getTitles()});
    }
}
