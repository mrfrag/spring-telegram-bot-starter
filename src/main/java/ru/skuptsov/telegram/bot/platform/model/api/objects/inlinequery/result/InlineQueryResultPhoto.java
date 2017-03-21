package ru.skuptsov.telegram.bot.platform.model.api.objects.inlinequery.result;

import javax.validation.ValidationException;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.skuptsov.telegram.bot.platform.model.api.objects.inlinequery.inputmessagecontent.InputMessageContent;
import ru.skuptsov.telegram.bot.platform.model.api.objects.replykeyboard.InlineKeyboardMarkup;

/**
 * @brief Represents a link to a photo. By default, this photo will be sent by
 *        the user with optional caption. Alternatively, you can use
 *        input_message_content to send a message with the specified content
 *        instead of the photo.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class InlineQueryResultPhoto extends InlineQueryResult {

	private static final String PHOTOURL_FIELD = "photo_url";
	private static final String MIMETYPE_FIELD = "mime_type";
	private static final String PHOTOWIDTH_FIELD = "photo_width";
	private static final String PHOTOHEIGHT_FIELD = "photo_height";
	private static final String PHOTOFILEID_FIELD = "photo_file_id";

	@Builder
	private InlineQueryResultPhoto(String id, String title, InputMessageContent inputMessageContent, InlineKeyboardMarkup replyMarkup, String thumbUrl, Integer thumbWidth, Integer thumbHeight, String photoUrl, String mimeType,
			Integer photoWidth, Integer photoHeight, String description, String caption, String photoFileId) {
		super(id, title, inputMessageContent, replyMarkup, thumbUrl, thumbWidth, thumbHeight);
		this.photoUrl = photoUrl;
		this.mimeType = mimeType;
		this.photoWidth = photoWidth;
		this.photoHeight = photoHeight;
		this.description = description;
		this.caption = caption;
		this.photoFileId = photoFileId;
	}

	/**
	 * A valid URL of the photo. Photo size must not exceed 5MB
	 */
	@JsonProperty(PHOTOURL_FIELD)
	private String photoUrl;

	/**
	 * Optional. MIME type of the photo, defaults to image/jpeg
	 */
	@JsonProperty(MIMETYPE_FIELD)
	private String mimeType;

	/**
	 * Optional. Width of the photo
	 */
	@JsonProperty(PHOTOWIDTH_FIELD)
	private Integer photoWidth;

	/**
	 * Optional. Height of the photo
	 */
	@JsonProperty(PHOTOHEIGHT_FIELD)
	private Integer photoHeight;

	/**
	 * Optional. Short description of the result
	 */
	private String description;

	/**
	 * Optional. Caption of the photo to be sent
	 */
	private String caption;

	/**
	 * A valid file identifier of the photo
	 */
	@JsonProperty(PHOTOFILEID_FIELD)
	private String photoFileId;

	@Override
	public void validate() {
		super.validate();
		if (photoUrl == null || photoUrl.isEmpty()) {
			throw new ValidationException("PhotoUrl parameter can't be empty");
		}
	}

	@JsonIgnore
	public boolean isCached() {
		return photoFileId != null;
	}

}
