package ru.skuptsov.telegram.bot.platform.model.api.objects.inlinequery;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import ru.skuptsov.telegram.bot.platform.model.api.objects.Location;
import ru.skuptsov.telegram.bot.platform.model.api.objects.User;

/**
 * @brief Represents a result of an inline query that was chosen by the user and
 *        sent to their chat partner.
 */
@Data
public class ChosenInlineQuery {

	private static final String RESULTID_FIELD = "result_id";
	private static final String INLINE_MESSAGE_ID_FIELD = "inline_message_id";

	/**
	 * The unique identifier for the result that was chosen.
	 */
	@JsonProperty(RESULTID_FIELD)
	private String resultId;

	/**
	 * The user that chose the result.
	 */
	private User from;

	/**
	 * Optional. Sender location, only for bots that require user location
	 */
	private Location location;

	/**
	 * Optional. Identifier of the sent inline message. Available only if there
	 * is an inline keyboard attached to the message. Will be also received in
	 * callback queries and can be used to edit the message.
	 */
	@JsonProperty(INLINE_MESSAGE_ID_FIELD)
	private String inlineMessageId;

	/**
	 * The query that was used to obtain the result.
	 */
	private String query;

}
