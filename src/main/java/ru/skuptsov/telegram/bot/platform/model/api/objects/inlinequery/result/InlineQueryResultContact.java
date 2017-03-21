package ru.skuptsov.telegram.bot.platform.model.api.objects.inlinequery.result;

import javax.validation.ValidationException;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.skuptsov.telegram.bot.platform.model.api.objects.inlinequery.inputmessagecontent.InputMessageContent;
import ru.skuptsov.telegram.bot.platform.model.api.objects.replykeyboard.InlineKeyboardMarkup;

/**
 * @brief Represents a contact with a phone number. By default, this contact
 *        will be sent by the user. Alternatively, you can use
 *        input_message_content to send a message with the specified content
 *        instead of the contact.
 * @note This will only work in Telegram versions released after 9 April, 2016.
 *       Older clients will ignore them.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class InlineQueryResultContact extends InlineQueryResult {

	private static final String PHONE_NUMBER_FIELD = "phone_number";
	private static final String FIRST_NAME_FIELD = "first_name";
	private static final String LAST_NAME_FIELD = "last_name";

	@Builder
	private InlineQueryResultContact(String id, String title, InputMessageContent inputMessageContent, InlineKeyboardMarkup replyMarkup, String thumbUrl, Integer thumbWidth, Integer thumbHeight, String phoneNumber, String firstName,
			String lastName) {
		super(id, title, inputMessageContent, replyMarkup, thumbUrl, thumbWidth, thumbHeight);
		this.phoneNumber = phoneNumber;
		this.firstName = firstName;
		this.lastName = lastName;
	}

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
	 * Contact's last name
	 */
	@JsonProperty(LAST_NAME_FIELD)
	private String lastName;

	@Override
	public void validate() throws ValidationException {
		super.validate();
		if (phoneNumber == null || phoneNumber.isEmpty()) {
			throw new ValidationException("PhoneNumber parameter can't be empty");
		}
		if (firstName == null || firstName.isEmpty()) {
			throw new ValidationException("FirstName parameter can't be empty");
		}
	}

}
