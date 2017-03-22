package ru.skuptsov.telegram.bot.platform.model.api.methods.message;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.skuptsov.telegram.bot.platform.model.api.methods.EditMessageBotApiMethod;
import ru.skuptsov.telegram.bot.platform.model.api.objects.replykeyboard.InlineKeyboardMarkup;

@Data
@EqualsAndHashCode(callSuper = true)
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

}
