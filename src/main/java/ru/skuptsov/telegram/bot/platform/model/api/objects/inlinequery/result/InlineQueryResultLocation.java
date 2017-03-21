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
 * @brief Represents a location on a map. By default, the location will be sent
 *        by the user. Alternatively, you can use input_message_content to send
 *        a message with the specified content instead of the location.
 * @note This will only work in Telegram versions released after 9 April, 2016.
 *       Older clients will ignore them.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class InlineQueryResultLocation extends InlineQueryResult {

	private static final String LATITUDE_FIELD = "latitude";
	private static final String LONGITUDE_FIELD = "longitude";

	@Builder
	private InlineQueryResultLocation(String id, String title, InputMessageContent inputMessageContent, InlineKeyboardMarkup replyMarkup, String thumbUrl,
			Integer thumbWidth, Integer thumbHeight, Float latitude, Float longitude) {
		super(id, title, inputMessageContent, replyMarkup, thumbUrl, thumbWidth, thumbHeight);
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * Location latitude in degrees
	 */
	@JsonProperty(LATITUDE_FIELD)
	private Float latitude;

	/**
	 * Location longitude in degrees
	 */
	@JsonProperty(LONGITUDE_FIELD)
	private Float longitude;

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
