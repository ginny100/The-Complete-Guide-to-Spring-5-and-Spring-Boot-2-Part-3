package io.datajek.springdata.tennisplayer;

import java.sql.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TennisPlayerApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PlayerDao dao;

	public static void main(String[] args) {
		SpringApplication.run(TennisPlayerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Get info of all players
		logger.info("All Players Data: {}", dao.getAllPlayers());
		// Get one player with a given id
		logger.info("Player with Id 3: {}", dao.getPlayerById(3));
		// Insert new player into the table
		logger.info("Inserting Player 4: {}", dao.insertPlayer(new Player(4, "Thiem", "Austria", new Date(System.currentTimeMillis()), 17)));
		logger.info("All Players Data: {}", dao.getAllPlayers());
	}
}
