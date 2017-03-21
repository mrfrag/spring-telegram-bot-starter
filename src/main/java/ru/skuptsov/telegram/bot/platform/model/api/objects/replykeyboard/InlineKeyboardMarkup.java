package ru.skuptsov.telegram.bot.platform.model.api.objects.replykeyboard;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ValidationException;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import ru.skuptsov.telegram.bot.platform.model.api.objects.replykeyboard.buttons.InlineKeyboardButton;

/**
 * @brief This object represents an inline keyboard that appears right next to
 *        the message it belongs to
 * @note Inline keyboards are currently being tested and are only available in
 *       one-on-one chats (i.e., user-bot or user-user in the case of inline
 *       bots).
 */
@Data
public class InlineKeyboardMarkup implements ReplyKeyboard {

	private static final String KEYBOARD_FIELD = "inline_keyboard";

	/**
	 * Array of button rows, each represented by an Array of Strings
	 */
	@JsonProperty(KEYBOARD_FIELD)
	private List<List<InlineKeyboardButton>> keyboard;

	public InlineKeyboardMarkup() {
		super();
		keyboard = new ArrayList<>();
	}

	public List<List<InlineKeyboardButton>> getKeyboard() {
		return keyboard;
	}

	public InlineKeyboardMarkup setKeyboard(List<List<InlineKeyboardButton>> keyboard) {
		this.keyboard = keyboard;
		return this;
	}

	@Override
	public void validate() {
		if (keyboard == null) {
			throw new ValidationException("Keyboard parameter can't be null");
		}
		for (List<InlineKeyboardButton> inlineKeyboardButtons : keyboard) {
			for (InlineKeyboardButton inlineKeyboardButton : inlineKeyboardButtons) {
				inlineKeyboardButton.validate();
			}
		}
	}

}
