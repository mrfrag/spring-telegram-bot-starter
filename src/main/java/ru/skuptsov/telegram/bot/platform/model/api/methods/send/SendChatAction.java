package ru.skuptsov.telegram.bot.platform.model.api.methods.send;

import javax.validation.ValidationException;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.skuptsov.telegram.bot.platform.model.api.methods.ChatBotApiMethod;

@Data
@EqualsAndHashCode(callSuper = true)
public class SendChatAction extends ChatBotApiMethod {

	/**
	 * Type of action to broadcast. Choose one, depending on what the user is
	 * about to receive: 'typing' for text messages 'upload_photo' for photos
	 * 'record_video' or 'upload_video' for videos 'record_audio' or
	 * 'upload_audio' for audio files 'upload_document' for general files,
	 * 'find_location' for location data.
	 */
	private ActionTypes action;

	@Builder
	private SendChatAction(String chatId, ActionTypes action) {
		super(chatId);
		this.action = action;
	}

	@Override
	public void validate() {
		super.validate();
		if (action == null) {
			throw new ValidationException("Action parameter can't be empty");
		}
	}

	public static enum ActionTypes {

		TYPING, RECORD_VIDEO, RECORD_AUDIO, UPLOAD_PHOTO, UPLOAD_VIDEO, UPLOAD_AUDIO, UPLOAD_DOCUMENT, FIND_LOCATION;

		@JsonCreator
		public static ActionTypes fromJson(String value) {
			return valueOf(value.toUpperCase());
		}

		@JsonValue
		public String toJson() {
			return name().toLowerCase();
		}

	}

}
