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
public class SendPhoto extends SendFileBotApiMethod {

	public static final String PHOTO_FIELD = "photo";
	public static final String CAPTION_FIELD = "caption";

	/**
	 * Photo to send. file_id as String to resend a photo that is already on the
	 * Telegram servers
	 * 
	 */
	private String photo;

	/**
	 * Optional Photo caption (may also be used when resending photos by
	 * file_id).
	 */
	private String caption;

	@Builder
	private SendPhoto(String chatId, Integer replyToMessageId, Boolean disableNotification, ReplyKeyboard replyMarkup, File file, String photo, String caption) {
		super(chatId, replyToMessageId, disableNotification, replyMarkup, file);
		this.photo = photo;
		this.caption = caption;
	}

	@Override
	protected String getFileFieldName() {
		return PHOTO_FIELD;
	}

	@Override
	protected BoundRequestBuilder populateRequestDetails(BoundRequestBuilder requestBuilder) {
		return requestBuilder.addBodyPart(new StringPart(CAPTION_FIELD, caption, "text/plain", Charset.forName("utf-8")));
	}
}
