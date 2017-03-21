package ru.skuptsov.telegram.bot.platform.model.api.objects.replykeyboard.buttons;

import javax.validation.ValidationException;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class KeyboardButton {

	private static final String TEXT_FIELD = "text";
	private static final String REQUEST_CONTACT_FIELD = "request_contact";
	private static final String REQUEST_LOCATION_FIELD = "request_location";

	/**
	 * Text of the button. If none of the optional fields are used, it will be
	 * sent to the bot as a message when the button is pressed
	 */
	@JsonProperty(TEXT_FIELD)
	private String text;

	/**
	 * Optional. If True, the user's phone number will be sent as a contact when
	 * the button is pressed. Available in private chats only
	 */
	@JsonProperty(REQUEST_CONTACT_FIELD)
	private Boolean requestContact;

	/**
	 * Optional. If True, the user's current location will be sent when the
	 * button is pressed. Available in private chats only
	 */
	@JsonProperty(REQUEST_LOCATION_FIELD)
	private Boolean requestLocation;

	public KeyboardButton(String text) {
		this.text = text;
	}

	public void validate() {
		if (text == null || text.isEmpty()) {
			throw new ValidationException("Text parameter can't be empty");
		}
	}

	@Override
	public String toString() {
		return "KeyboardButton{" +
				"text=" + text +
				", requestContact=" + requestContact +
				", requestLocation=" + requestLocation +
				'}';
	}
}
