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
 * @brief Represents link to a page containing an embedded video player or a
 *        video file. Alternatively, you can use input_message_content to send a
 *        message with the specified content instead of the video.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class InlineQueryResultVideo extends InlineQueryResult {

	private static final String MIMETYPE_FIELD = "mime_type";
	private static final String VIDEOURL_FIELD = "video_url";
	private static final String VIDEOWIDTH_FIELD = "video_width";
	private static final String VIDEOHEIGHT_FIELD = "video_height";
	private static final String VIDEODURATION_FIELD = "video_duration";
	private static final String VIDEO_FILE_ID_FIELD = "video_file_id";

	@Builder
	private InlineQueryResultVideo(String id, String title, InputMessageContent inputMessageContent, InlineKeyboardMarkup replyMarkup, String thumbUrl, Integer thumbWidth, Integer thumbHeight, String mimeType, String videoUrl,
			Integer videoWidth, Integer videoHeight, Integer videoDuration, String description, String caption, String videoFileId) {
		super(id, title, inputMessageContent, replyMarkup, thumbUrl, thumbWidth, thumbHeight);
		this.mimeType = mimeType;
		this.videoUrl = videoUrl;
		this.videoWidth = videoWidth;
		this.videoHeight = videoHeight;
		this.videoDuration = videoDuration;
		this.description = description;
		this.caption = caption;
		this.videoFileId = videoFileId;
	}

	/**
	 * Mime type of the content of video url, i.e. “text/html” or
	 * “video/mp4”
	 */
	@JsonProperty(MIMETYPE_FIELD)
	private String mimeType;

	/**
	 * A valid URL for the embedded video player or video file
	 */
	@JsonProperty(VIDEOURL_FIELD)
	private String videoUrl;

	/**
	 * Optional. Video width
	 */
	@JsonProperty(VIDEOWIDTH_FIELD)
	private Integer videoWidth;

	/**
	 * Optional. Video height
	 */
	@JsonProperty(VIDEOHEIGHT_FIELD)
	private Integer videoHeight;

	/**
	 * Optional. Video duration in seconds
	 */
	@JsonProperty(VIDEODURATION_FIELD)
	private Integer videoDuration;

	/**
	 * Optional. Short description of the result
	 */
	private String description;

	/**
	 * Optional. Caption of the video to be sent, 0-200 characters
	 */
	private String caption;

	/**
	 * A valid file identifier for the video file
	 */
	@JsonProperty(VIDEO_FILE_ID_FIELD)
	private String videoFileId;

	@Override
	public void validate() {
		super.validate();
		if (videoUrl == null || videoUrl.isEmpty()) {
			throw new ValidationException("VideoUrl parameter can't be empty");
		}
	}

	@JsonIgnore
	public boolean isCached() {
		return videoFileId != null;
	}

}
