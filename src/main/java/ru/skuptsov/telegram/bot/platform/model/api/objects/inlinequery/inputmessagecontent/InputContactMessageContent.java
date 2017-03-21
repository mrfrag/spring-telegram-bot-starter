package ru.skuptsov.telegram.bot.platform.model.api.objects.inlinequery.inputmessagecontent;

import javax.validation.ValidationException;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @brief Represents the content of a contact message to be sent as the result
 *        of an inline query
 * @note This will only work in Telegram versions released after 9 April, 2016.
 *       Older clients will ignore them.
 */
@Data
public class InputContactMessageContent implements InputMessageContent {

	private static final String PHONE_NUMBER_FIELD = "phone_number";
	private static final String FIRST_NAME_FIELD = "first_name";
	private static final String LAST_NAME_FIELD = "last_name";

	/**
	 * Contact's phone number
	 */
	@JsonProperty(PHONE_NUMBER_FIELD)
	private String phoneNumber;

	/**
	 * Contact's first name
	 */
	@JsonProperty(FIRST_NAME_FIELD)
	private String firstName;

	/**
	 * Optional. Contact's last name
	 */
	@JsonProperty(LAST_NAME_FIELD)
	private String lastName;

	@Override
	public void validate() {
		if (phoneNumber == null || phoneNumber.isEmpty()) {
			throw new ValidationException("PhoneNumber parameter can't be empty");
		}
		if (firstName == null || firstName.isEmpty()) {
			throw new ValidationException("FirstName parameter can't be empty");
		}
	}

}
