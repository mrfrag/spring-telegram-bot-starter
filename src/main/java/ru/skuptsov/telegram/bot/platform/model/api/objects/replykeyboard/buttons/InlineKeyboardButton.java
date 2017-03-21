package ru.skuptsov.telegram.bot.platform.model.api.objects.replykeyboard.buttons;

import javax.validation.ValidationException;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import ru.skuptsov.telegram.bot.platform.model.api.objects.games.CallbackGame;

/**
 * @version 1.0
 * @brief This object represents one button of an inline keyboard. You must use
 *        exactly one of the optional fields.
 * @note This will only work in Telegram versions released after 9 April, 2016.
 *       Older clients will display unsupported message.
 * @date 10 of April of 2016
 */
@Data
public class InlineKeyboardButton {

	private static final String TEXT_FIELD = "text";
	private static final String URL_FIELD = "url";
	private static final String CALLBACK_DATA_FIELD = "callback_data";
	private static final String CALLBACK_GAME_FIELD = "callback_game";
	private static final String SWITCH_INLINE_QUERY_FIELD = "switch_inline_query";
	private static final String SWITCH_INLINE_QUERY_CURRENT_CHAT_FIELD = "switch_inline_query_current_chat";

	/**
	 * Label text on the button
	 */
	@JsonProperty(TEXT_FIELD)
	private String text;

	/**
	 * Optional. HTTP url to be opened when button is pressed
	 */
	@JsonProperty(URL_FIELD)
	private String url;

	/**
	 * Optional. Data to be sent in a callback query to the bot when button is
	 * pressed
	 */
	@JsonProperty(CALLBACK_DATA_FIELD)
	private String callbackData;

	/**
	 * Optional. Description of the game that will be launched when the user
	 * presses the button.
	 *
	 * @note This type of button must always be the first button in the first
	 *       row.
	 */
	@JsonProperty(CALLBACK_GAME_FIELD)
	private CallbackGame callbackGame;

	/**
	 * Optional. If set, pressing the button will prompt the user to select one
	 * of their chats, open that chat and insert the botвЂ�s username and the
	 * specified inline query in the input field. Can be empty, in which case
	 * just the botвЂ™s username will be inserted.
	 * 
	 * @note: This offers an easy way for users to start using your bot in
	 *        inline mode when they are currently in a private chat with it.
	 *        Especially useful when combined with switch_pmвЂ¦ actions вЂ“ in
	 *        this case the user will be automatically returned to the chat they
	 *        switched from, skipping the chat selection screen.
	 */
	@JsonProperty(SWITCH_INLINE_QUERY_FIELD)
	private String switchInlineQuery;

	/**
	 * Optional. If set, pressing the button will insert the botвЂ�s username
	 * and the specified inline query in the current chat's input field. Can be
	 * empty, in which case only the botвЂ™s username will be inserted.
	 */
	@JsonProperty(SWITCH_INLINE_QUERY_CURRENT_CHAT_FIELD)
	private String switchInlineQueryCurrentChat;

	public void validate() {
		if (text == null || text.isEmpty()) {
			throw new ValidationException("Text parameter can't be empty");
		}
	}

}
