package ru.skuptsov.telegram.bot.platform.model.api.objects.inlinequery;

import lombok.Data;
import ru.skuptsov.telegram.bot.platform.model.api.objects.Location;
import ru.skuptsov.telegram.bot.platform.model.api.objects.User;

/**
 * @brief This object represents an incoming inline query. When the user sends
 *        an empty query, your bot could return some default or trending
 *        results.
 */
@Data
public class InlineQuery {

	/**
	 * Unique identifier for this query
	 */
	private String id;

	/**
	 * Sender
	 */
	private User from;

	/**
	 * Optional. Sender location, only for bots that request user location
	 */
	private Location location;

	/**
	 * Text of the query
	 */
	private String query;

	/**
	 * Offset of the results to be returned, can be controlled by the bot
	 */
	private String offset;

}
