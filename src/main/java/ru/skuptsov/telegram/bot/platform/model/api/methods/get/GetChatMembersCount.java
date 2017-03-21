package ru.skuptsov.telegram.bot.platform.model.api.methods.get;

import lombok.Builder;
import ru.skuptsov.telegram.bot.platform.model.api.methods.ChatBotApiMethod;

public class GetChatMembersCount extends ChatBotApiMethod {

	@Builder
	private GetChatMembersCount(String chatId) {
		super(chatId);
	}

}
