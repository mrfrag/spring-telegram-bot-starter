package ru.skuptsov.telegram.bot.platform.model.api.methods.send;

import javax.validation.ValidationException;

import lombok.Builder;
import lombok.ToString;
import ru.skuptsov.telegram.bot.platform.model.api.methods.SendBotApiMethod;
import ru.skuptsov.telegram.bot.platform.model.api.objects.replykeyboard.ReplyKeyboard;

@ToString
public class SendVenue extends SendBotApiMethod {

	public static final String LATITUDE_FIELD = "latitude";
	public static final String LONGITUDE_FIELD = "longitude";
	public static final String TITLE_FIELD = "title";
	public static final String ADDRESS_FIELD = "address";
	public static final String FOURSQUARE_ID_FIELD = "foursquare_id";

	/**
	 * Latitude of venue location
	 */
	private Float latitude;

	/**
	 * Longitude of venue location
	 */
	private Float longitude;

	/**
	 * Title of the venue
	 */
	private String title;

	/**
	 * Address of the venue
	 */
	private String address;

	/**
	 * Optional. Foursquare identifier of the venue
	 */
	private String foursquareId;

	@Builder
	private SendVenue(String chatId, Integer replyToMessageId, Boolean disableNotification, ReplyKeyboard replyMarkup, Float latitude, Float longitude, String title, String address, String foursquareId) {
		super(chatId, replyToMessageId, disableNotification, replyMarkup);
		this.latitude = latitude;
		this.longitude = longitude;
		this.title = title;
		this.address = address;
		this.foursquareId = foursquareId;
	}

	@Override
	public void validate() {
		super.validate();
		if (longitude == null) {
			throw new ValidationException("Longitude parameter can't be empty");
		}
		if (latitude == null) {
			throw new ValidationException("Latitude parameter can't be empty");
		}
		if (title == null || title.isEmpty()) {
			throw new ValidationException("Title parameter can't be empty");
		}
		if (address == null) {
			throw new ValidationException("Address parameter can't be empty");
		}
	}

}
