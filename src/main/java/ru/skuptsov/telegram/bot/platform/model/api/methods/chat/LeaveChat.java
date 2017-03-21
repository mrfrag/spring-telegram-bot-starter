package ru.skuptsov.telegram.bot.platform.model.api.methods.chat;

import lombok.Builder;
import ru.skuptsov.telegram.bot.platform.model.api.methods.ChatBotApiMethod;

public class LeaveChat extends ChatBotApiMethod {

	@Builder
	private LeaveChat(String chatId) {
		super(chatId);
	}

}
