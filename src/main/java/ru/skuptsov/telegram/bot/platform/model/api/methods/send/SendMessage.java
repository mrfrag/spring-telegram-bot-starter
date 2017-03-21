package ru.skuptsov.telegram.bot.platform.model.api.methods.send;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.skuptsov.telegram.bot.platform.model.api.methods.SendBotApiMethod;
import ru.skuptsov.telegram.bot.platform.model.api.objects.replykeyboard.ReplyKeyboard;

@ToString
public class SendMessage extends SendBotApiMethod {

	public static final String TEXT_FIELD = "text";
	public static final String PARSEMODE_FIELD = "parse_mode";
	public static final String DISABLEWEBPAGEPREVIEW_FIELD = "disable_web_page_preview";

	/**
	 * Text of the message to be sent
	 */
	@Getter
	@Setter
	private String text;

	/**
	 * Optional. Send Markdown, if you want Telegram apps to show bold, italic
	 * and URL text in your bot's message.
	 */
	@JsonProperty(PARSEMODE_FIELD)
	private ParseModes parseMode;

	/**
	 * Optional. Disables link previews for links in this message
	 */
	@Getter
	@JsonProperty(DISABLEWEBPAGEPREVIEW_FIELD)
	private Boolean disableWebPagePreview;

	@Builder
	private SendMessage(String chatId, String text, ParseModes parseMode, Boolean disableWebPagePreview, Integer replyToMessageId, Boolean disableNotification, ReplyKeyboard replyMarkup) {
		super(chatId, replyToMessageId, disableNotification, replyMarkup);
		this.text = text;
		this.parseMode = parseMode;
		this.disableWebPagePreview = disableNotification;
	}

	public SendMessage disableWebPagePreview() {
		disableWebPagePreview = true;
		return this;
	}

	public SendMessage enableWebPagePreview() {
		disableWebPagePreview = null;
		return this;
	}

}
