package ru.skuptsov.telegram.bot.platform.model.api.methods.send;

import java.io.File;
import java.nio.charset.Charset;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ning.http.client.AsyncHttpClient.BoundRequestBuilder;
import com.ning.http.client.multipart.StringPart;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.skuptsov.telegram.bot.platform.model.api.methods.SendFileBotApiMethod;
import ru.skuptsov.telegram.bot.platform.model.api.objects.replykeyboard.ReplyKeyboard;

@Data
@EqualsAndHashCode(callSuper = true)
public class SendAudio extends SendFileBotApiMethod {

	public static final String DURATION_FIELD = "duration";
	public static final String AUDIO_FIELD = "audio";

	public static final String PERFORMER_FIELD = "performer";
	public static final String TITLE_FIELD = "title";

	/**
	 * Integer Duration of the audio in seconds as defined by sender
	 */
	@JsonProperty(DURATION_FIELD)
	private Integer duration;

	/**
	 * Audio file to send. file_id as String to resend an audio that is already
	 * on the Telegram servers
	 */
	@JsonProperty(AUDIO_FIELD)
	private String audio;

	/**
	 * Optional. Performer of sent audio
	 */
	@JsonProperty(PERFORMER_FIELD)
	private String performer;

	/**
	 * Optional. Title of sent audio
	 */
	@JsonProperty(TITLE_FIELD)
	private String title;

	@Builder
	private SendAudio(String chatId, Integer replyToMessageId, Boolean disableNotification, ReplyKeyboard replyMarkup, File file, Integer duration, String audio, String performer, String title) {
		super(chatId, replyToMessageId, disableNotification, replyMarkup, file);
		this.duration = duration;
		this.audio = audio;
		this.performer = performer;
		this.title = title;
	}

	@Override
	protected String getFileFieldName() {
		return AUDIO_FIELD;
	}

	@Override
	protected BoundRequestBuilder populateRequestDetails(BoundRequestBuilder requestBuilder) {
		return requestBuilder	.addBodyPart(new StringPart(DURATION_FIELD, duration.toString()))
								.addBodyPart(new StringPart(PERFORMER_FIELD, performer, "text/plain", Charset.forName("utf-8")))
								.addBodyPart(new StringPart(TITLE_FIELD, title, "text/plain", Charset.forName("utf-8")));
	}

}
