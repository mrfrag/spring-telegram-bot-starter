package ru.skuptsov.telegram.bot.platform.model.api.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @brief This object represents a venue.
 */
@Data
public class Venue {

	private static final String FOURSQUARE_ID_FIELD = "foursquare_id";

	/**
	 * Venue location
	 */
	private Location location;

	/**
	 * Name of the venue
	 */
	private String title;

	/**
	 * Address of the venue
	 */
	private String address;

	/**
	 * Optional. Foursquare identifier of the venue
	 */
	@JsonProperty(FOURSQUARE_ID_FIELD)
	private String foursquareId;

}
