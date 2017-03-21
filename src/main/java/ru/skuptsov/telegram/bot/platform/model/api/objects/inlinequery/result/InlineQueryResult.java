package ru.skuptsov.telegram.bot.platform.model.api.objects.inlinequery.result;

import javax.validation.ValidationException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import lombok.Data;
import ru.skuptsov.telegram.bot.platform.model.api.objects.inlinequery.inputmessagecontent.InputMessageContent;
import ru.skuptsov.telegram.bot.platform.model.api.objects.replykeyboard.InlineKeyboardMarkup;

/**
 * @brief This object represents one result of an inline query.
 */
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
@JsonSubTypes({
		@Type(name = "article", value = InlineQueryResultArticle.class),
		@Type(name = "audio", value = InlineQueryResultAudio.class),
		@Type(name = "contact", value = InlineQueryResultContact.class),
		@Type(name = "document", value = InlineQueryResultDocument.class),
		@Type(name = "game", value = InlineQueryResultGame.class),
		@Type(name = "gif", value = InlineQueryResultGif.class),
		@Type(name = "location", value = InlineQueryResultLocation.class),
		@Type(name = "mpeg4gif", value = InlineQueryResultMpeg4Gif.class),
		@Type(name = "photo", value = InlineQueryResultPhoto.class),
		@Type(name = "venue", value = InlineQueryResultVenue.class),
		@Type(name = "video", value = InlineQueryResultVideo.class),
		@Type(name = "voice", value = InlineQueryResultVoice.class),
		@Type(name = "sticker", value = InlineQueryResultSticker.class)
})
@Data
public abstract class InlineQueryResult {

	private static final String INPUTMESSAGECONTENT_FIELD = "input_message_content";
	private static final String REPLY_MARKUP_FIELD = "reply_markup";
	private static final String THUMBURL_FIELD = "thumb_url";
	private static final String THUMBWIDTH_FIELD = "thumb_width";
	private static final String THUMBHEIGHT_FIELD = "thumb_height";

	/**
	 * Unique identifier of this result, 1-64 bytes
	 */
	private String id;

	/**
	 * Title of the result
	 */
	private String title;

	/**
	 * Content of the message to be sent
	 */
	@JsonProperty(INPUTMESSAGECONTENT_FIELD)
	private InputMessageContent inputMessageContent;

	/**
	 * Optional. Inline keyboard attached to the message
	 */
	@JsonProperty(REPLY_MARKUP_FIELD)
	private InlineKeyboardMarkup replyMarkup;

	/**
	 * Optional. Url of the thumbnail for the result
	 */
	@JsonProperty(THUMBURL_FIELD)
	private String thumbUrl;

	/**
	 * Optional. Thumbnail width
	 */
	@JsonProperty(THUMBWIDTH_FIELD)
	private Integer thumbWidth;

	/**
	 * Optional. Thumbnail height
	 */
	@JsonProperty(THUMBHEIGHT_FIELD)
	private Integer thumbHeight;

	protected InlineQueryResult() {

	}

	protected InlineQueryResult(String id, String title, InputMessageContent inputMessageContent, InlineKeyboardMarkup replyMarkup, String thumbUrl, Integer thumbWidth, Integer thumbHeight) {
		this.id = id;
		this.title = title;
		this.inputMessageContent = inputMessageContent;
		this.replyMarkup = replyMarkup;
		this.thumbUrl = thumbUrl;
		this.thumbWidth = thumbWidth;
		this.thumbHeight = thumbHeight;
	}

	public void validate() {
		if (id == null || id.isEmpty()) {
			throw new ValidationException("ID parameter can't be empty");
		}
		if (title == null || title.isEmpty()) {
			throw new ValidationException("Title parameter can't be empty");
		}
		if (inputMessageContent != null) {
			inputMessageContent.validate();
		}
		if (replyMarkup != null) {
			replyMarkup.validate();
		}
	}

}
