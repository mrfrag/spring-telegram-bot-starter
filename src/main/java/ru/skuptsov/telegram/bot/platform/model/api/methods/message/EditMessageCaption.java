package ru.skuptsov.telegram.bot.platform.model.api.methods.message;

import lombok.Builder;
import lombok.ToString;
import ru.skuptsov.telegram.bot.platform.model.api.methods.EditMessageBotApiMethod;
import ru.skuptsov.telegram.bot.platform.model.api.objects.replykeyboard.InlineKeyboardMarkup;

@ToString
public class EditMessageCaption extends EditMessageBotApiMethod {

	public static final String CAPTION_FIELD = "caption";

	/**
	 * Optional. New caption of the message
	 */
	private String caption;

	@Builder
	private EditMessageCaption(String chatId, Integer messageId, String inlineMessageId, InlineKeyboardMarkup replyMarkup, String caption) {
		super(chatId, messageId, inlineMessageId, replyMarkup);
		this.caption = caption;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

}
