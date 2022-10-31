package io.datajek.springdatajpa.tennisplayer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PlayerRepository {
    @PersistenceContext
    EntityManager entityManager;

    /**
     * Insert new Player to the table
     * @param player
     * @return a Player object which has been inserted
     */
    public Player insertPlayer(Player player) {
        return entityManager.merge(player);
    }

    /**
     * Update an existing Player in the table
     * @param player
     * @return a Player object which has been updated
     */
    public Player updatePlayer(Player player) {
        return entityManager.merge(player);
    }

    /**
     * Find an existing Player with the given id
     * @param id
     * @return
     */
    public Player getPlayerById(int id) {
        return entityManager.find(Player.class, id);
    }

    /**
     * Delete an existing Player with the given id
     * @param id
     */
    public void deletePlayerById(int id){
        Player player = entityManager.find(Player.class, id);
        entityManager.remove(player);
    }

}
