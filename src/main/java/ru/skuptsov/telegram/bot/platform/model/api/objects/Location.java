package ru.skuptsov.telegram.bot.platform.model.api.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @version 1.0
 * @brief This object represents a point on the map.
 * @date 20 of June of 2015
 */
@Data
public class Location {

	private static final String LONGITUDE_FIELD = "longitude";
	private static final String LATITUDE_FIELD = "latitude";

	/**
	 * Longitude as defined by sender
	 */
	@JsonProperty(LONGITUDE_FIELD)
	private Double longitude;

	/**
	 * Latitude as defined by sender
	 */
	@JsonProperty(LATITUDE_FIELD)
	private Double latitude;

	@Override
	public String toString() {
		return "Location{" +
				"longitude=" + longitude +
				", latitude=" + latitude +
				'}';
	}
}
