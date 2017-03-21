package ru.skuptsov.telegram.bot.platform.model.api.objects.replykeyboard;

import javax.validation.ValidationException;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @brief Upon receiving a message with this object, Telegram clients will hide
 *        the current custom keyboard and display the default letter-keyboard.
 *        By default, custom keyboards are displayed until a new keyboard is
 *        sent by a bot. An exception is made for one-time keyboards that are
 *        hidden immediately after the user presses a button (@see
 *        ReplyKeyboardMarkup).
 */
@Data
public class ReplyKeyboardHide implements ReplyKeyboard {

	private static final String HIDEKEYBOARD_FIELD = "hide_keyboard";
	private static final String SELECTIVE_FIELD = "selective";

	/**
	 * Requests clients to hide the custom keyboard
	 */
	@JsonProperty(HIDEKEYBOARD_FIELD)
	private Boolean hideKeyboard;

	/**
	 * Optional. Use this parameter if you want to show the keyboard to specific
	 * users only. Targets: 1) users that are @mentioned in the text of the
	 * Message object; 2) if the bot's message is a reply (has
	 * reply_to_message_id), sender of the original message.
	 */
	@JsonProperty(SELECTIVE_FIELD)
	private Boolean selective;

	@Override
	public void validate() {
		if (hideKeyboard == null) {
			throw new ValidationException("Hidekeyboard parameter can't be null");
		}
	}

}
