package ru.skuptsov.telegram.bot.platform.model.api.methods.message;

import lombok.Builder;
import ru.skuptsov.telegram.bot.platform.model.api.methods.EditMessageBotApiMethod;
import ru.skuptsov.telegram.bot.platform.model.api.objects.replykeyboard.InlineKeyboardMarkup;

public class EditMessageReplyMarkup extends EditMessageBotApiMethod {

	@Builder
	private EditMessageReplyMarkup(String chatId, Integer messageId, String inlineMessageId, InlineKeyboardMarkup replyMarkup) {
		super(chatId, messageId, inlineMessageId, replyMarkup);
	}

}
