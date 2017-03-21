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
 * @brief Represents a link to an mp3 audio file. By default, this audio file
 *        will be sent by the user. Alternatively, you can use
 *        input_message_content to send a message with the specified content
 *        instead of the audio.
 * @note This will only work in Telegram versions released after 9 April, 2016.
 *       Older clients will ignore them.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class InlineQueryResultAudio extends InlineQueryResult {

	private static final String AUDIOURL_FIELD = "audio_url";
	private static final String PERFORMER_FIELD = "performer";
	private static final String AUDIO_DURATION_FIELD = "audio_duration";
	private static final String CAPTION_FIELD = "caption";
	private static final String AUDIO_FILE_ID_FIELD = "audio_file_id";

	@Builder
	private InlineQueryResultAudio(String id, String title, InputMessageContent inputMessageContent, InlineKeyboardMarkup replyMarkup, String thumbUrl, Integer thumbWidth, Integer thumbHeight, String audioUrl, String performer,
			Integer audioDuration, String caption, String audioFileId) {
		super(id, title, inputMessageContent, replyMarkup, thumbUrl, thumbWidth, thumbHeight);
		this.audioUrl = audioUrl;
		this.performer = performer;
		this.audioDuration = audioDuration;
		this.caption = caption;
		this.audioFileId = audioFileId;
	}

	/**
	 * A valid URL for the audio file
	 */
	@JsonProperty(AUDIOURL_FIELD)
	private String audioUrl;

	/**
	 * Optional. Performer
	 */
	@JsonProperty(PERFORMER_FIELD)
	private String performer;

	/**
	 * Optional. Audio duration in seconds
	 */
	@JsonProperty(AUDIO_DURATION_FIELD)
	private Integer audioDuration;

	/**
	 * Optional. Audio caption (may also be used when resending documents by
	 * file_id), 0-200 characters
	 */
	@JsonProperty(CAPTION_FIELD)
	private String caption;

	/**
	 * A valid file identifier for the audio file
	 */
	@JsonProperty(AUDIO_FILE_ID_FIELD)
	private String audioFileId;

	@JsonIgnore
	public boolean isCached() {
		return audioFileId != null;
	}

	@Override
	public void validate() {
		super.validate();
		if (audioUrl == null || audioUrl.isEmpty()) {
			throw new ValidationException("AudioUrl parameter can't be empty");
		}
	}

}
