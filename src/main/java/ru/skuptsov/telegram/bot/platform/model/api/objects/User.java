package ru.skuptsov.telegram.bot.platform.model.api.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @brief This object represents a Telegram user or bot.
 */
@Data
public class User {

	private static final String FIRSTNAME_FIELD = "first_name";
	private static final String LASTNAME_FIELD = "last_name";

	/**
	 * Unique identifier for this user or bot
	 */
	private Integer id;

	/**
	 * UserвЂ�s or botвЂ™s first name
	 */
	@JsonProperty(FIRSTNAME_FIELD)
	private String firstName;

	/**
	 * Optional. UserвЂ�s or botвЂ™s last name
	 */
	@JsonProperty(LASTNAME_FIELD)
	private String lastName;

	/**
	 * Optional. UserвЂ�s or botвЂ™s username
	 */
	private String userName;

}
