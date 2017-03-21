package ru.skuptsov.telegram.bot.platform.model.api.objects.games;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import ru.skuptsov.telegram.bot.platform.model.api.objects.MessageEntity;
import ru.skuptsov.telegram.bot.platform.model.api.objects.PhotoSize;

/**
 * @brief This object represents a game. Use BotFather to create and edit games,
 *        their short names will act as unique identifiers.
 */
@Data
public class Game {

	private static final String TEXTENTITIES_FIELD = "text_entities";

	/**
	 * Title of the game
	 */
	private String title;

	/**
	 * Description of the game
	 */
	private String description;

	/**
	 * Photo
	 */
	private List<PhotoSize> photo;

	/**
	 * Optional. Brief description of the game or high scores included in the
	 * game message. Can be automatically edited to include current high scores
	 * for the game when the bot calls setGameScore, or manually edited using
	 * editMessageText. 0-4096 characters.
	 */
	private String text;

	/**
	 * Optional. Special entities that appear in text, such as usernames, URLs,
	 * bot commands, etc.
	 */
	@JsonProperty(TEXTENTITIES_FIELD)
	private List<MessageEntity> entities;

	/**
	 * Optional. Animation
	 */
	private Animation animation;

	@Override
	public String toString() {
		return "Game{" +
				"title='" + title + '\'' +
				", description='" + description + '\'' +
				", photo=" + photo +
				", animation=" + animation +
				'}';
	}
}
