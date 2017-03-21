package ru.skuptsov.telegram.bot.platform.model.api.methods.get;

import lombok.Builder;
import ru.skuptsov.telegram.bot.platform.model.api.methods.ChatBotApiMethod;

public class GetChatAdministrators extends ChatBotApiMethod {

	@Builder
	private GetChatAdministrators(String chatId) {
		super(chatId);
	}

}
