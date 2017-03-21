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
 * @brief Represents a link to an animated GIF file. By default, this animated
 *        GIF file will be sent by the user with optional caption.
 *        Alternatively, you can use input_message_content to send a message
 *        with the specified content instead of the animation.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class InlineQueryResultGif extends InlineQueryResult {

	private static final String GIFURL_FIELD = "gif_url";
	private static final String GIFWIDTH_FIELD = "gif_width";
	private static final String GIFHEIGHT_FIELD = "gif_height";
	private static final String CAPTION_FIELD = "caption";
	private static final String GIF_FILE_ID_FIELD = "gif_file_id";

	@Builder
	private InlineQueryResultGif(String id, String title, InputMessageContent inputMessageContent, InlineKeyboardMarkup replyMarkup, String thumbUrl, Integer thumbWidth, Integer thumbHeight, String gifUrl, Integer gifWidth,
			Integer gifHeight, String caption, String gifFileId) {
		super(id, title, inputMessageContent, replyMarkup, thumbUrl, thumbWidth, thumbHeight);
		this.gifUrl = gifUrl;
		this.gifWidth = gifWidth;
		this.gifHeight = gifHeight;
		this.caption = caption;
		this.gifFileId = gifFileId;
	}

	/**
	 * A valid URL for the GIF file. File size must not exceed 1MB
	 */
	@JsonProperty(GIFURL_FIELD)
	private String gifUrl;

	/**
	 * Optional. Width of the GIF
	 */
	@JsonProperty(GIFWIDTH_FIELD)
	private Integer gifWidth;

	/**
	 * Optional. Height of the GIF
	 */
	@JsonProperty(GIFHEIGHT_FIELD)
	private Integer gifHeight;

	/**
	 * Optional. Caption of the GIF file to be sent
	 */
	@JsonProperty(CAPTION_FIELD)
	private String caption;

	/**
	 * A valid file identifier for the GIF file
	 */
	@JsonProperty(GIF_FILE_ID_FIELD)
	private String gifFileId;

	@Override
	public void validate() {
		super.validate();
		if (gifUrl == null || gifUrl.isEmpty()) {
			throw new ValidationException("GifUrl parameter can't be empty");
		}
	}

	@JsonIgnore
	public boolean isCached() {
		return gifFileId != null;
	}

}
