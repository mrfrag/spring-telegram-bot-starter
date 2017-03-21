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
 * @brief Represents a venue. By default, the venue will be sent by the user.
 *        Alternatively, you can use input_message_content to send a message
 *        with the specified content instead of the venue.
 * @note This will only work in Telegram versions released after 9 April, 2016.
 *       Older clients will ignore them.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class InlineQueryResultVenue extends InlineQueryResult {

	private static final String LATITUDE_FIELD = "latitude";
	private static final String LONGITUDE_FIELD = "longitude";
	private static final String ADDRESS_FIELD = "address";
	private static final String FOURSQUARE_ID_FIELD = "foursquare_id";

	@Builder
	private InlineQueryResultVenue(String id, String title, InputMessageContent inputMessageContent, InlineKeyboardMarkup replyMarkup, String thumbUrl, Integer thumbWidth, Integer thumbHeight, Float latitude, Float longitude,
			String address, String foursquareId) {
		super(id, title, inputMessageContent, replyMarkup, thumbUrl, thumbWidth, thumbHeight);
		this.latitude = latitude;
		this.longitude = longitude;
		this.address = address;
		this.foursquareId = foursquareId;
	}

	/**
	 * Venue latitude in degrees
	 */
	@JsonProperty(LATITUDE_FIELD)
	private Float latitude;

	/**
	 * Venue longitude in degrees
	 */
	@JsonProperty(LONGITUDE_FIELD)
	private Float longitude;

	/**
	 * Address of the venue
	 */
	@JsonProperty(ADDRESS_FIELD)
	private String address;

	/**
	 * Optional. Foursquare identifier of the venue if known
	 */
	@JsonProperty(FOURSQUARE_ID_FIELD)
	private String foursquareId;

	@Override
	public void validate() {
		super.validate();
		if (latitude == null) {
			throw new ValidationException("Latitude parameter can't be empty");
		}
		if (longitude == null) {
			throw new ValidationException("Longitude parameter can't be empty");
		}
		if (address == null || address.isEmpty()) {
			throw new ValidationException("Longitude parameter can't be empty");
		}
	}

}
