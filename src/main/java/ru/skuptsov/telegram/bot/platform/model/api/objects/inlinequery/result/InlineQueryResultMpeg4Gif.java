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
 * @brief Represents a link to a video animation (H.264/MPEG-4 AVC video without
 *        sound). By default, this animated MPEG-4 file will be sent by the user
 *        with optional caption. Alternatively, you can use
 *        input_message_content to send a message with the specified content
 *        instead of the animation.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class InlineQueryResultMpeg4Gif extends InlineQueryResult {

	private static final String MPEG4URL_FIELD = "mpeg4_url";
	private static final String MPEG4WIDTH_FIELD = "mpeg4_width";
	private static final String MPEG4HEIGHT_FIELD = "mpeg4_height";
	private static final String MPEG4_FILE_ID_FIELD = "mpeg4_file_id";

	@Builder
	private InlineQueryResultMpeg4Gif(String id, String title, InputMessageContent inputMessageContent, InlineKeyboardMarkup replyMarkup, String thumbUrl, Integer thumbWidth, Integer thumbHeight, String mpeg4Url, Integer mpeg4Width,
			Integer mpeg4Height, String caption, String mpeg4FileId) {
		super(id, title, inputMessageContent, replyMarkup, thumbUrl, thumbWidth, thumbHeight);
		this.mpeg4Url = mpeg4Url;
		this.mpeg4Width = mpeg4Width;
		this.mpeg4Height = mpeg4Height;
		this.caption = caption;
		this.mpeg4FileId = mpeg4FileId;
	}

	/**
	 * A valid URL for the MP4 file. File size must not exceed 1MB
	 */
	@JsonProperty(MPEG4URL_FIELD)
	private String mpeg4Url;

	/**
	 * Optional. Video width
	 */
	@JsonProperty(MPEG4WIDTH_FIELD)
	private Integer mpeg4Width;

	/**
	 * Optional. Video height
	 */
	@JsonProperty(MPEG4HEIGHT_FIELD)
	private Integer mpeg4Height;

	/**
	 * Optional. Caption of the MPEG-4 file to be sent
	 */
	private String caption;

	/**
	 * A valid file identifier for the MP4 file
	 */
	@JsonProperty(MPEG4_FILE_ID_FIELD)
	private String mpeg4FileId;

	@Override
	public void validate() {
		super.validate();
		if (mpeg4Url == null || mpeg4Url.isEmpty()) {
			throw new ValidationException("Mpeg4Url parameter can't be empty");
		}
	}

	@JsonIgnore
	public boolean isCached() {
		return mpeg4FileId != null;
	}

}
