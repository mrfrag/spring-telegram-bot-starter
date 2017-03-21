package ru.skuptsov.telegram.bot.platform.model.api.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import ru.skuptsov.telegram.bot.platform.model.api.objects.inlinequery.ChosenInlineQuery;
import ru.skuptsov.telegram.bot.platform.model.api.objects.inlinequery.InlineQuery;

@Data
public class Update {

	private static final String UPDATEID_FIELD = "update_id";
	private static final String INLINEQUERY_FIELD = "inline_query";
	private static final String CHOSENINLINEQUERY_FIELD = "chosen_inline_result";
	private static final String CALLBACKQUERY_FIELD = "callback_query";
	private static final String EDITEDMESSAGE_FIELD = "edited_message";

	@JsonProperty(UPDATEID_FIELD)
	private Integer updateId;

	/**
	 * Optional. New incoming message of any kind — text, photo, sticker, etc.
	 */
	private Message message;

	/**
	 * Optional. New incoming inline query
	 */
	@JsonProperty(INLINEQUERY_FIELD)
	private InlineQuery inlineQuery;

	/**
	 * Optional. The result of a inline query that was chosen by a user and sent
	 * to their chat partner
	 */
	@JsonProperty(CHOSENINLINEQUERY_FIELD)
	private ChosenInlineQuery chosenInlineQuery;

	/**
	 * Optional. New incoming callback query
	 */
	@JsonProperty(CALLBACKQUERY_FIELD)
	private CallbackQuery callbackQuery;

	/**
	 * Optional. New version of a message that is known to the bot and was
	 * edited
	 */
	@JsonProperty(EDITEDMESSAGE_FIELD)
	private Message editedMessage;

}
