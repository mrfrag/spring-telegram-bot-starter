package ru.skuptsov.telegram.bot.platform.model.api.methods.send;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.skuptsov.telegram.bot.platform.model.api.methods.SendBotApiMethod;
import ru.skuptsov.telegram.bot.platform.model.api.objects.replykeyboard.ReplyKeyboard;

@Data
@EqualsAndHashCode(callSuper = true)
public class SendMessage extends SendBotApiMethod {

	public static final String PARSEMODE_FIELD = "parse_mode";
	public static final String DISABLEWEBPAGEPREVIEW_FIELD = "disable_web_page_preview";

	/**
	 * Text of the message to be sent
	 */
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
	@JsonProperty(DISABLEWEBPAGEPREVIEW_FIELD)
	private Boolean disableWebPagePreview;

	@Builder
	private SendMessage(String chatId, String text, ParseModes parseMode, Boolean disableWebPagePreview, Integer replyToMessageId, Boolean disableNotification, ReplyKeyboard replyMarkup) {
		super(chatId, replyToMessageId, disableNotification, replyMarkup);
		this.text = text;
		this.parseMode = parseMode;
		this.disableWebPagePreview = disableNotification;
	}

}
