package ru.skuptsov.telegram.bot.platform.model.api.methods.send;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.skuptsov.telegram.bot.platform.model.api.methods.SendBotApiMethod;
import ru.skuptsov.telegram.bot.platform.model.api.objects.replykeyboard.ReplyKeyboard;

@Data
@EqualsAndHashCode(callSuper = true)
public class SendContact extends SendBotApiMethod {

	private static final String PHONE_NUMBER_FIELD = "phone_number";
	private static final String FIRST_NAME_FIELD = "first_name";
	private static final String LAST_NAME_FIELD = "last_name";

	/**
	 * User's phone number
	 */
	@JsonProperty(PHONE_NUMBER_FIELD)
	private String phoneNumber;

	/**
	 * User's first name
	 */
	@JsonProperty(FIRST_NAME_FIELD)
	private String firstName;

	/**
	 * Optional. User's last name
	 */
	@JsonProperty(LAST_NAME_FIELD)
	private String lastName;

	@Builder
	private SendContact(String chatId, Integer replyToMessageId, Boolean disableNotification, ReplyKeyboard replyMarkup, String phoneNumber, String firstName, String lastName) {
		super(chatId, replyToMessageId, disableNotification, replyMarkup);
		this.phoneNumber = phoneNumber;
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
