package ru.skuptsov.telegram.bot.platform.model.api.objects.inlinequery.inputmessagecontent;

import javax.validation.ValidationException;

import lombok.Data;

/**
 * @brief Represents the content of a location message to be sent as the result
 *        of an inline query.
 * @note This will only work in Telegram versions released after 9 April, 2016.
 *       Older clients will ignore them.
 */
@Data
public class InputLocationMessageContent implements InputMessageContent {

	/**
	 * Latitude of the location in degrees
	 */
	private Float latitude;

	/**
	 * Longitude of the location in degrees
	 */
	private Float longitude;

	@Override
	public void validate() {
		if (latitude == null) {
			throw new ValidationException("Latitude parameter can't be empty");
		}
		if (longitude == null) {
			throw new ValidationException("Longitude parameter can't be empty");
		}
	}

}
