package ru.skuptsov.telegram.bot.platform.model.api.methods;

import javax.validation.ValidationException;

import com.fasterxml.jackson.annotation.JsonProperty;

import ru.skuptsov.telegram.bot.platform.model.api.objects.replykeyboard.InlineKeyboardMarkup;

public abstract class EditMessageBotApiMethod extends ChatBotApiMethod {

	private static final String MESSAGEID_FIELD = "message_id";
	private static final String INLINE_MESSAGE_ID_FIELD = "inline_message_id";
	private static final String REPLYMARKUP_FIELD = "reply_markup";

	/**
	 * Required if inline_message_id is not specified. Unique identifier of the
	 * sent message
	 */
	@JsonProperty(MESSAGEID_FIELD)
	private Integer messageId;

	/**
	 * Required if chat_id and message_id are not specified. Identifier of the
	 * inline message
	 */
	@JsonProperty(INLINE_MESSAGE_ID_FIELD)
	private String inlineMessageId;

	/**
	 * Optional. A JSON-serialized object for an inline keyboard.
	 */
	@JsonProperty(REPLYMARKUP_FIELD)
	private InlineKeyboardMarkup replyMarkup;

	protected EditMessageBotApiMethod(String chatId, Integer messageId, String inlineMessageId, InlineKeyboardMarkup replyMarkup) {
		super(chatId);
		this.messageId = messageId;
		this.inlineMessageId = inlineMessageId;
		this.replyMarkup = replyMarkup;
	}

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public String getInlineMessageId() {
		return inlineMessageId;
	}

	public void setInlineMessageId(String inlineMessageId) {
		this.inlineMessageId = inlineMessageId;
	}

	public InlineKeyboardMarkup getReplyMarkup() {
		return replyMarkup;
	}

	public void setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
		this.replyMarkup = replyMarkup;
	}

	@Override
	public void validate() {
		if (inlineMessageId == null) {
			if (getChatId() == null) {
				throw new ValidationException("ChatId parameter can't be empty if inlineMessageId is not present");
			}
			if (messageId == null) {
				throw new ValidationException("MessageId parameter can't be empty if inlineMessageId is not present");
			}
		} else {
			if (getChatId() != null) {
				throw new ValidationException("ChatId parameter must be empty if inlineMessageId is provided");
			}
			if (messageId != null) {
				throw new ValidationException("MessageId parameter must be empty if inlineMessageId is provided");
			}
		}
	}

}
