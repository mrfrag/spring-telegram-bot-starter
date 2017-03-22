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
public class SendVideo extends SendFileBotApiMethod {

	public static final String VIDEO_FIELD = "video";
	public static final String DURATION_FIELD = "duration";
	public static final String CAPTION_FIELD = "caption";
	public static final String WIDTH_FIELD = "width";
	public static final String HEIGHT_FIELD = "height";

	/**
	 * Video to send. file_id as String to resend a video that is already on the
	 * Telegram servers
	 */
	private String video;

	/**
	 * Optional. Duration of sent video in seconds
	 */
	private Integer duration;

	/**
	 * OptionaL. Video caption (may also be used when resending videos by
	 * file_id).
	 */
	private String caption;

	/**
	 * Optional. Video width
	 */
	private Integer width;

	/**
	 * OptionaL. Video height
	 */
	private Integer height;

	@Builder
	private SendVideo(String chatId, Integer replyToMessageId, Boolean disableNotification, ReplyKeyboard replyMarkup, File file, String video, Integer duration, String caption, Integer width, Integer height) {
		super(chatId, replyToMessageId, disableNotification, replyMarkup, file);
		this.video = video;
		this.duration = duration;
		this.caption = caption;
		this.width = width;
		this.height = height;
	}

	@Override
	protected String getFileFieldName() {
		return VIDEO_FIELD;
	}

	@Override
	protected BoundRequestBuilder populateRequestDetails(BoundRequestBuilder requestBuilder) {
		return requestBuilder	.addBodyPart(new StringPart(DURATION_FIELD, duration.toString(), "text/plain", Charset.forName("utf-8")))
								.addBodyPart(new StringPart(WIDTH_FIELD, width.toString(), "text/plain", Charset.forName("utf-8")))
								.addBodyPart(new StringPart(HEIGHT_FIELD, height.toString(), "text/plain", Charset.forName("utf-8")))
								.addBodyPart(new StringPart(CAPTION_FIELD, caption, "text/plain", Charset.forName("utf-8")));
	}
}
