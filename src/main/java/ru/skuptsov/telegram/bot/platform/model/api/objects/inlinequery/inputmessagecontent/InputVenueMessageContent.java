package ru.skuptsov.telegram.bot.platform.model.api.objects.inlinequery.inputmessagecontent;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @brief Represents the content of a venue message to be sent as the result of
 *        an inline query.
 * @note This will only work in Telegram versions released after 9 April, 2016.
 *       Older clients will ignore them.
 */
@Data
public class InputVenueMessageContent implements InputMessageContent {

	private static final String FOURSQUARE_ID_FIELD = "foursquare_id";

	/**
	 * Latitude of the venue in degrees
	 */
	private Float latitude;

	/**
	 * Longitude of the venue in degrees
	 */
	private Float longitude;

	/**
	 * Name of the venue
	 */
	private String title;

	/**
	 * Address of the venue
	 */
	private String address;

	/**
	 * Optional. Foursquare identifier of the venue, if known
	 */
	@JsonProperty(FOURSQUARE_ID_FIELD)
	private String foursquareId;

	@Override
	public void validate() {

	}

}
