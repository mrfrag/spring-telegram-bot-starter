package ru.skuptsov.telegram.bot.platform.model.api.methods.send;

import javax.validation.ValidationException;

import lombok.Builder;
import ru.skuptsov.telegram.bot.platform.model.api.methods.ChatBotApiMethod;

public class SendChatAction extends ChatBotApiMethod {

	public static final String ACTION_FIELD = "action";

	/**
	 * Type of action to broadcast. Choose one, depending on what the user is
	 * about to receive: 'typing' for text messages 'upload_photo' for photos
	 * 'record_video' or 'upload_video' for videos 'record_audio' or
	 * 'upload_audio' for audio files 'upload_document' for general files,
	 * 'find_location' for location data.
	 */
	private ActionType action;

	@Builder
	private SendChatAction(String chatId, ActionType action) {
		super(chatId);
		this.action = action;
	}

	public void setAction(ActionType action) {
		this.action = action;
	}

	public ActionType getAction() {
		return action;
	}

	@Override
	public void validate() {
		super.validate();
		if (action == null) {
			throw new ValidationException("Action parameter can't be empty");
		}
	}

	@Override
	public String toString() {
		return "SendChatAction{" +
				"chatId='" + getChatId() + '\'' +
				", action='" + action + '\'' +
				'}';
	}

	public static enum ActionType {

		TYPING("typing"), RECORDVIDEO("record_video"), RECORDAUDIO("record_audio"), UPLOADPHOTO("upload_photo"), UPLOADVIDEO("upload_video"), UPLOADAUDIO("upload_audio"), UPLOADDOCUMENT("upload_document"), FINDLOCATION("find_location");

		private String text;

		ActionType(String text) {
			this.text = text;
		}

		@Override
		public String toString() {
			return text;
		}
	}

}
