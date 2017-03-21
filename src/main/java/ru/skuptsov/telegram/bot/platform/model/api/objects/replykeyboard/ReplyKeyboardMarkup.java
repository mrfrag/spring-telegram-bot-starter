package ru.skuptsov.telegram.bot.platform.model.api.objects.replykeyboard;

import java.util.List;

import javax.validation.ValidationException;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import ru.skuptsov.telegram.bot.platform.model.api.objects.replykeyboard.buttons.KeyboardRow;

/**
 * @brief This object represents a custom keyboard with reply options.
 */
@Data
public class ReplyKeyboardMarkup implements ReplyKeyboard {

	private static final String KEYBOARD_FIELD = "keyboard";
	private static final String RESIZEKEYBOARD_FIELD = "resize_keyboard";
	private static final String ONETIMEKEYBOARD_FIELD = "one_time_keyboard";
	private static final String SELECTIVE_FIELD = "selective";

	/**
	 * Array of button rows, each represented by an Array of Strings
	 */
	@JsonProperty(KEYBOARD_FIELD)
	private List<KeyboardRow> keyboard;

	/**
	 * Optional. Requests clients to resize the keyboard vertically for optimal
	 * fit (e.g., make the keyboard smaller if there are just two rows of
	 * buttons). Defaults to false.
	 */
	@JsonProperty(RESIZEKEYBOARD_FIELD)
	private Boolean resizeKeyboard;

	/**
	 * Optional. Requests clients to hide the keyboard as soon as it's been
	 * used. Defaults to false.
	 */
	@JsonProperty(ONETIMEKEYBOARD_FIELD)
	private Boolean oneTimeKeyboad;

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
		if (keyboard == null) {
			throw new ValidationException("Keyboard parameter can't be null");
		}
		for (KeyboardRow keyboardButtons : keyboard) {
			keyboardButtons.validate();
		}
	}

}
