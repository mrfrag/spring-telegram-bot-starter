package ru.skuptsov.telegram.bot.platform.model.api.methods.message;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import ru.skuptsov.telegram.bot.platform.model.api.methods.ChatBotApiMethod;

public class ForwardMessage extends ChatBotApiMethod {

	private static final String FROMCHATID_FIELD = "from_chat_id";
	private static final String MESSAGEID_FIELD = "message_id";
	private static final String DISABLENOTIFICATION_FIELD = "disable_notification";

	/**
	 * Unique identifier for the chat where the original message was sent —
	 * User or GroupChat id
	 */
	@JsonProperty(FROMCHATID_FIELD)
	private String fromChatId;

	/**
	 * Unique message identifier
	 */
	@JsonProperty(MESSAGEID_FIELD)
	private Integer messageId;

	/**
	 * Optional. Sends the message silently. iOS users will not receive a
	 * notification, Android users will receive a notification with no sound.
	 * Other apps coming soon
	 */
	@JsonProperty(DISABLENOTIFICATION_FIELD)
	private Boolean disableNotification;

	@Builder
	private ForwardMessage(String chatId, String fromChatId, Integer messageId, Boolean disableNotification) {
		super(chatId);
		this.fromChatId = fromChatId;
		this.messageId = messageId;
		this.disableNotification = disableNotification;
	}

	public String getFromChatId() {
		return fromChatId;
	}

	public void setFromChatId(String fromChatId) {
		this.fromChatId = fromChatId;
	}

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public Boolean getDisableNotification() {
		return disableNotification;
	}

	public ForwardMessage enableNotification() {
		this.disableNotification = false;
		return this;
	}

	public ForwardMessage disableNotification() {
		this.disableNotification = true;
		return this;
	}

	@Override
	public String toString() {
		return "ForwardMessage{" +
				"chatId='" + getChatId() + '\'' +
				", fromChatId=" + fromChatId +
				", messageId=" + messageId +
				'}';
	}
}
