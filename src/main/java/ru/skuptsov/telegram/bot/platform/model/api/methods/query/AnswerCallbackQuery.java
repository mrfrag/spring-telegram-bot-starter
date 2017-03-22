package ru.skuptsov.telegram.bot.platform.model.api.methods.query;

import javax.validation.ValidationException;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.skuptsov.telegram.bot.platform.model.api.methods.BotApiMethod;

/**
 * @brief Use this method to send answers to callback queries sent from inline
 *        keyboards. The answer will be displayed to the user as a notification
 *        at the top of the chat screen or as an alert. On success, True is
 *        returned.
 *
 * @note Alternatively, the user can be redirected to the specified URL. For
 *       this option to work, you must enable /setcustomurls for your bot via
 *       BotFather and accept the terms.
 *
 */
@Builder
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class AnswerCallbackQuery extends BotApiMethod {

	private static final String CALLBACKQUERYID_FIELD = "callback_query_id";
	private static final String SHOWALERT_FIELD = "show_alert";

	/**
	 * Unique identifier for the query to be answered
	 */
	@JsonProperty(CALLBACKQUERYID_FIELD)
	private String callbackQueryId;

	/**
	 * Optional Text of the notification. If not specified, nothing will be
	 * shown to the user, 0-200 characters
	 */
	private String text;

	/**
	 * Optional. If true, an alert will be shown by the client instead of a
	 * notificaiton at the top of the chat screen. Defaults to false.
	 */
	@JsonProperty(SHOWALERT_FIELD)
	private Boolean showAlert;

	/**
	 * Optional. URL that will be opened by the user's client. If you have
	 * created a Game and accepted the conditions via @Botfather, specify the
	 * URL that opens your game. Otherwise you may use links
	 * InlineQueryResultGamelike telegram.me/your_bot?start=XXXX that open your
	 * bot with a parameter.
	 */
	private String url;

	@Override
	public void validate() {
		if (callbackQueryId == null) {
			throw new ValidationException("CallbackQueryId can't be null");
		}
	}

}
