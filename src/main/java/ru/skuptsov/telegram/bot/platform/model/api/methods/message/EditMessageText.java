package ru.skuptsov.telegram.bot.platform.model.api.methods.message;

import javax.validation.ValidationException;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.ToString;
import ru.skuptsov.telegram.bot.platform.model.api.methods.EditMessageBotApiMethod;
import ru.skuptsov.telegram.bot.platform.model.api.objects.replykeyboard.InlineKeyboardMarkup;

@ToString
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
	private String parseMode;

	/**
	 * Optional. Disables link previews for links in this message
	 */
	@JsonProperty(DISABLE_WEB_PREVIEW_FIELD)
	private Boolean disableWebPagePreview;

	@Builder
	private EditMessageText(String chatId, Integer messageId, String inlineMessageId, InlineKeyboardMarkup replyMarkup, String text, String parseMode, Boolean disableWebPagePreview) {
		super(chatId, messageId, inlineMessageId, replyMarkup);
		this.text = text;
		this.parseMode = parseMode;
		this.disableWebPagePreview = disableWebPagePreview;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public EditMessageText disableWebPagePreview() {
		disableWebPagePreview = true;
		return this;
	}

	public EditMessageText enableWebPagePreview() {
		disableWebPagePreview = null;
		return this;
	}

	public EditMessageText enableMarkdown(boolean enable) {
		if (enable) {
			this.parseMode = "markdown";
		} else {
			this.parseMode = null;
		}
		return this;
	}

	public EditMessageText enableHtml(boolean enable) {
		if (enable) {
			this.parseMode = "html";
		} else {
			this.parseMode = null;
		}
		return this;
	}

	@Override
	public void validate() {
		super.validate();
		if (text == null || text.isEmpty()) {
			throw new ValidationException("Text parameter can't be empty");
		}
	}

}
