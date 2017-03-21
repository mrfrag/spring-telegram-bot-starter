package ru.skuptsov.telegram.bot.platform.model.api.objects.inlinequery.result;

import javax.validation.ValidationException;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.skuptsov.telegram.bot.platform.model.api.objects.inlinequery.inputmessagecontent.InputMessageContent;
import ru.skuptsov.telegram.bot.platform.model.api.objects.replykeyboard.InlineKeyboardMarkup;

/**
 * @brief Represents a Game
 * @note This will only work in Telegram versions released after 1 October,
 *       2016. Older clients will ignore them.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class InlineQueryResultGame extends InlineQueryResult {

	private static final String GAMESHORTNAME_FIELD = "game_short_name";

	@Builder
	private InlineQueryResultGame(String id, String title, InputMessageContent inputMessageContent, InlineKeyboardMarkup replyMarkup, String thumbUrl, Integer thumbWidth, Integer thumbHeight, String gameShortName) {
		super(id, title, inputMessageContent, replyMarkup, thumbUrl, thumbWidth, thumbHeight);
		this.gameShortName = gameShortName;
	}

	/**
	 * Short name of the game
	 */
	@JsonProperty(GAMESHORTNAME_FIELD)
	private String gameShortName;

	@Override
	public void validate() {
		super.validate();
		if (gameShortName == null || gameShortName.isEmpty()) {
			throw new ValidationException("GameShortName parameter can't be empty");
		}
	}

}
