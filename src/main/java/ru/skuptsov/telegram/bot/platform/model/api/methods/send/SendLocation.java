package ru.skuptsov.telegram.bot.platform.model.api.methods.send;

import javax.validation.ValidationException;

import lombok.Builder;
import lombok.ToString;
import ru.skuptsov.telegram.bot.platform.model.api.methods.SendBotApiMethod;
import ru.skuptsov.telegram.bot.platform.model.api.objects.replykeyboard.ReplyKeyboard;

@ToString
public class SendLocation extends SendBotApiMethod {

	public static final String LATITUDE_FIELD = "latitude";
	public static final String LONGITUDE_FIELD = "longitude";

	/**
	 * Latitude of location
	 */
	private Float latitude;

	/**
	 * Longitude of location
	 */
	private Float longitude;

	@Builder
	private SendLocation(String chatId, Integer replyToMessageId, Boolean disableNotification, ReplyKeyboard replyMarkup, Float latitude, Float longitude) {
		super(chatId, replyToMessageId, disableNotification, replyMarkup);
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	@Override
	public void validate() {
		super.validate();
		if (latitude == null) {
			throw new ValidationException("Latitude parameter can't be empty");
		}
		if (longitude == null) {
			throw new ValidationException("Longitude parameter can't be empty");
		}
	}

}
