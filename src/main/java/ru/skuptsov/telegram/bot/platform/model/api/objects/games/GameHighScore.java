package ru.skuptsov.telegram.bot.platform.model.api.objects.games;

import lombok.Data;
import ru.skuptsov.telegram.bot.platform.model.api.objects.User;

/**
 * @brief This object represents one row of a game high scores table
 */
@Data
public class GameHighScore {

	/**
	 * Position in the game high score table
	 */
	private Integer position;

	/**
	 * User
	 */
	private User user;

	/**
	 * Score
	 */
	private Integer score;

	@Override
	public String toString() {
		return "GameHighScore{" +
				"position=" + position +
				", user=" + user +
				", score=" + score +
				'}';
	}
}
