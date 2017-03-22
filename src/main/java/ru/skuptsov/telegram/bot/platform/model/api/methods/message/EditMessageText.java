package ru.skuptsov.telegram.bot.platform.model.api.methods.message;

import javax.validation.ValidationException;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.skuptsov.telegram.bot.platform.model.api.methods.EditMessageBotApiMethod;
import ru.skuptsov.telegram.bot.platform.model.api.objects.replykeyboard.InlineKeyboardMarkup;

@Data
@EqualsAndHashCode(callSuper = true)
public class EditMessageText extends EditMessageBotApiMethod {

	public static final String TEXT_FIELD = "text";
	public static final String PARSE_MODE_FIELD = "parse_mode";
	public static final String DISABLE_WEB_PREVIEW_FIELD = "disable_web_page_preview";

	/**
	 * New text of the message
	 */
	private String text;

	/**
	 * Optional. Send Markdown or HTML, if you want Telegram apps to show bold,
	 * italic, fixed-width text or inline URLs in your bot's message.
	 */
	@JsonProperty(PARSE_MODE_FIELD)
	private ParseModes parseMode;

	/**
	 * Optional. Disables link previews for links in this message
	 */
	@JsonProperty(DISABLE_WEB_PREVIEW_FIELD)
	private Boolean disableWebPagePreview;

	@Builder
	private EditMessageText(String chatId, Integer messageId, String inlineMessageId, InlineKeyboardMarkup replyMarkup, String text, ParseModes parseMode, Boolean disableWebPagePreview) {
		super(chatId, messageId, inlineMessageId, replyMarkup);
		this.text = text;
		this.parseMode = parseMode;
		this.disableWebPagePreview = disableWebPagePreview;
	}

	@Override
	public void validate() {
		super.validate();
		if (text == null || text.isEmpty()) {
			throw new ValidationException("Text parameter can't be empty");
		}
	}

}
