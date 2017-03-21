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
 * @brief Represents a link to a voice recording in an .ogg container encoded
 *        with OPUS. By default, this voice recording will be sent by the user.
 *        Alternatively, you can use input_message_content to send a message
 *        with the specified content instead of the the voice message.
 * @note This will only work in Telegram versions released after 9 April, 2016.
 *       Older clients will ignore them.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class InlineQueryResultVoice extends InlineQueryResult {

	private static final String VOICEURL_FIELD = "voice_url";
	private static final String VOICE_DURATION_FIELD = "voice_duration";
	private static final String VOICE_FILE_ID_FIELD = "voice_file_id";

	@Builder
	private InlineQueryResultVoice(String id, String title, InputMessageContent inputMessageContent, InlineKeyboardMarkup replyMarkup, String thumbUrl, Integer thumbWidth, Integer thumbHeight, String voiceUrl, Integer voiceDuration,
			String caption, String voiceFileId) {
		super(id, title, inputMessageContent, replyMarkup, thumbUrl, thumbWidth, thumbHeight);
		this.voiceUrl = voiceUrl;
		this.voiceDuration = voiceDuration;
		this.caption = caption;
		this.voiceFileId = voiceFileId;
	}

	/**
	 * A valid URL for the voice recording
	 */
	@JsonProperty(VOICEURL_FIELD)
	private String voiceUrl;

	/**
	 * Optional. Recording duration in seconds
	 */
	@JsonProperty(VOICE_DURATION_FIELD)
	private Integer voiceDuration;

	/**
	 * Optional. Voice caption (may also be used when resending documents by
	 * file_id), 0-200 characters
	 */
	private String caption;

	/**
	 * A valid file identifier for the voice message
	 */
	@JsonProperty(VOICE_FILE_ID_FIELD)
	private String voiceFileId;

	@Override
	public void validate() {
		super.validate();
		if (voiceUrl == null || voiceUrl.isEmpty()) {
			throw new ValidationException("VoiceUrl parameter can't be empty");
		}
	}

	@JsonIgnore
	public boolean isCached() {
		return voiceFileId != null;
	}

}
