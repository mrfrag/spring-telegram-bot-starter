package ru.skuptsov.telegram.bot.platform.model.api.objects.inlinequery.inputmessagecontent;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @brief Represents the content of a text message to be sent as the result of
 *        an inline query.
 */
@Data
public class InputTextMessageContent implements InputMessageContent {

	private static final String MESSAGETEXT_FIELD = "message_text";
	private static final String PARSEMODE_FIELD = "parse_mode";
	private static final String DISABLEWEBPAGEPREVIEW_FIELD = "disable_web_page_preview";

	/**
	 * Text of a message to be sent, 1-4096 characters
	 */
	@JsonProperty(MESSAGETEXT_FIELD)
	private String messageText;

	/**
	 * Optional. Send Markdown or HTML, if you want Telegram apps to show bold,
	 * italic, fixed-width text or inline URLs in your bot's message.
	 */
	@JsonProperty(PARSEMODE_FIELD)
	private String parseMode;

	/**
	 * Optional. Disables link previews for links in the sent message
	 */
	@JsonProperty(DISABLEWEBPAGEPREVIEW_FIELD)
	private Boolean disableWebPagePreview;

	@Override
	public void validate() {

	}

}
