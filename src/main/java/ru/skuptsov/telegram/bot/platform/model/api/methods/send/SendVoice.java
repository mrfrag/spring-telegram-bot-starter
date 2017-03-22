package ru.skuptsov.telegram.bot.platform.model.api.methods.send;

import java.io.File;
import java.nio.charset.Charset;

import com.ning.http.client.AsyncHttpClient.BoundRequestBuilder;
import com.ning.http.client.multipart.StringPart;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.skuptsov.telegram.bot.platform.model.api.methods.SendFileBotApiMethod;
import ru.skuptsov.telegram.bot.platform.model.api.objects.replykeyboard.ReplyKeyboard;

@Data
@EqualsAndHashCode(callSuper = true)
public class SendVoice extends SendFileBotApiMethod {

	public static final String VOICE_FIELD = "voice";
	public static final String DURATION_FIELD = "duration";

	/**
	 * Audio file to send. You can either pass a file_id as String to resend an
	 * audio that is already on the Telegram servers, or upload a new audio file
	 * using multipart/form-data.
	 */
	private String voice;

	/**
	 * Optional. Duration of sent audio in seconds
	 */
	private Integer duration;

	@Builder
	private SendVoice(String chatId, Integer replyToMessageId, Boolean disableNotification, ReplyKeyboard replyMarkup, File file, String voice, Integer duration) {
		super(chatId, replyToMessageId, disableNotification, replyMarkup, file);
		this.voice = voice;
		this.duration = duration;
	}

	@Override
	protected String getFileFieldName() {
		return VOICE_FIELD;
	}

	@Override
	protected BoundRequestBuilder populateRequestDetails(BoundRequestBuilder requestBuilder) {
		return requestBuilder.addBodyPart(new StringPart(DURATION_FIELD, duration.toString(), "text/plain", Charset.forName("utf-8")));
	}
}
