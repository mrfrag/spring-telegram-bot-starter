package ru.skuptsov.telegram.bot.platform.model.api.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Contact {

	private static final String PHONENUMBER_FIELD = "phone_number";
	private static final String FIRSTNAME_FIELD = "first_name";
	private static final String LASTNAME_FIELD = "last_name";
	private static final String USERID_FIELD = "user_id";

	/**
	 * Contact's phone number
	 */
	@JsonProperty(PHONENUMBER_FIELD)
	private String phoneNumber;

	/**
	 * Contact's first name
	 */
	@JsonProperty(FIRSTNAME_FIELD)
	private String firstName;

	/**
	 * Optional. Contact's last name
	 */
	@JsonProperty(LASTNAME_FIELD)
	private String lastName;

	/**
	 * Optional. Contact's user identifier in Telegram
	 */
	@JsonProperty(USERID_FIELD)
	private Integer userID;

}
