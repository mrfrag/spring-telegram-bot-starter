package ru.skuptsov.telegram.bot.platform.model.api.methods;

import com.fasterxml.jackson.annotation.JsonProperty;

import ru.skuptsov.telegram.bot.platform.model.api.objects.replykeyboard.ReplyKeyboard;

public abstract class SendBotApiMethod extends ChatBotApiMethod {

	public static final String REPLYTOMESSAGEID_FIELD = "reply_to_message_id";
	public static final String DISABLENOTIFICATION_FIELD = "disable_notification";
	public static final String REPLYMARKUP_FIELD = "reply_markup";

	/**
	 * Optional. If the message is a reply, ID of the original message
	 */
	@JsonProperty(REPLYTOMESSAGEID_FIELD)
	private Integer replyToMessageId;

	/**
	 * Optional. Sends the message silently. iOS users will not receive a
	 * notification, Android users will receive a notification with no sound.
	 * Other apps coming soon
	 */
	@JsonProperty(DISABLENOTIFICATION_FIELD)
	private Boolean disableNotification;

	/**
	 * Optional. JSON-serialized object for a custom reply keyboard
	 */
	@JsonProperty(REPLYMARKUP_FIELD)
	private ReplyKeyboard replyMarkup;

	protected SendBotApiMethod(String chatId, Integer replyToMessageId, Boolean disableNotification, ReplyKeyboard replyMarkup) {
		super(chatId);
		this.disableNotification = disableNotification;
		this.replyToMessageId = replyToMessageId;
		this.replyMarkup = replyMarkup;
	}

	public Integer getReplyToMessageId() {
		return replyToMessageId;
	}

	public void setReplyToMessageId(Integer replyToMessageId) {
		this.replyToMessageId = replyToMessageId;
	}

	public Boolean getDisableNotification() {
		return disableNotification;
	}

	public void setDisableNotification(Boolean disableNotification) {
		this.disableNotification = disableNotification;
	}

	public ReplyKeyboard getReplyMarkup() {
		return replyMarkup;
	}

	public void setReplyMarkup(ReplyKeyboard replyMarkup) {
		this.replyMarkup = replyMarkup;
	}

}
