package ru.skuptsov.telegram.bot.platform.model.api.methods.chat;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.skuptsov.telegram.bot.platform.model.api.methods.ChatBotApiMethod;

public class KickChatMember extends ChatBotApiMethod {

	private static final String USER_ID_FIELD = "user_id";

	/**
	 * Unique identifier of the target user
	 */
	@Getter
	@Setter
	@JsonProperty(USER_ID_FIELD)
	private Integer userId;

	@Builder
	private KickChatMember(String chatId, Integer userId) {
		super(chatId);
		this.userId = userId;
	}

}
