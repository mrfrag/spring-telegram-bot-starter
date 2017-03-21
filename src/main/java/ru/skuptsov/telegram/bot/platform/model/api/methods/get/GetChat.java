package ru.skuptsov.telegram.bot.platform.model.api.methods.get;

import lombok.Builder;
import ru.skuptsov.telegram.bot.platform.model.api.methods.ChatBotApiMethod;

public class GetChat extends ChatBotApiMethod {

	@Builder
	private GetChat(String chatId) {
		super(chatId);
	}

}
