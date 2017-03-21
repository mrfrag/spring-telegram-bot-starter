package ru.skuptsov.telegram.bot.platform.model.api.objects.replykeyboard;

import javax.validation.ValidationException;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @brief Upon receiving a message with this object, Telegram clients will
 *        display a reply interface to the user (act as if the user has selected
 *        the botвЂ�s message and tapped вЂ™Reply'). This can be extremely
 *        useful if you want to create user-friendly step-by-step interfaces
 *        without having to sacrifice privacy mode.
 */
@Data
public class ForceReplyKeyboard implements ReplyKeyboard {

	private static final String FORCEREPLY_FIELD = "force_reply";
	private static final String SELECTIVE_FIELD = "selective";

	/**
	 * Shows reply interface to the user, as if they manually selected the
	 * botвЂ�s message and tapped вЂ™Reply'
	 */
	@JsonProperty(FORCEREPLY_FIELD)
	private Boolean forceReply;

	/**
	 * Use this parameter if you want to force reply from specific users only.
	 * Targets: 1) users that are @mentioned in the text of the Message object;
	 * 2) if the bot's message is a reply (has reply_to_message_id), sender of
	 * the original message.
	 */
	@JsonProperty(SELECTIVE_FIELD)
	private Boolean selective;

	@Override
	public void validate() {
		if (forceReply == null) {
			throw new ValidationException("ForceReply parameter can't not be null");
		}
	}

}
