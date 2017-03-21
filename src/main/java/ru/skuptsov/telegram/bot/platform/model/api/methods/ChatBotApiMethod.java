package ru.skuptsov.telegram.bot.platform.model.api.methods;

import javax.validation.ValidationException;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class ChatBotApiMethod extends BotApiMethod {

	public static final String CHATID_FIELD = "chat_id";

	/**
	 * Unique identifier for the chat to send the message to (or Username fro
	 * channels)
	 */
	@JsonProperty(CHATID_FIELD)
	private String chatId;

	protected ChatBotApiMethod(String chatId) {
		this.chatId = chatId;
	}

	@Override
	public void validate() {
		if (getChatId() == null) {
			throw new ValidationException("ChatId can't be null");
		}
	}

	public String getChatId() {
		return chatId;
	}

	public void setChatId(String chatId) {
		this.chatId = chatId;
	}

}
