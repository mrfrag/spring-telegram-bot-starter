package ru.skuptsov.telegram.bot.platform.model.api.methods.send;

import java.io.File;

import com.ning.http.client.AsyncHttpClient.BoundRequestBuilder;

import lombok.Builder;
import lombok.ToString;
import ru.skuptsov.telegram.bot.platform.model.api.methods.SendFileBotApiMethod;
import ru.skuptsov.telegram.bot.platform.model.api.objects.replykeyboard.ReplyKeyboard;

@ToString
public class SendSticker extends SendFileBotApiMethod {

	public static final String STICKER_FIELD = "sticker";

	/**
	 * Sticker file to send. file_id as String to resend a sticker that is
	 * already on the Telegram servers
	 */
	private String sticker;

	@Builder
	private SendSticker(String chatId, Integer replyToMessageId, Boolean disableNotification, ReplyKeyboard replyMarkup, File file, String sticker) {
		super(chatId, replyToMessageId, disableNotification, replyMarkup, file);
		this.sticker = sticker;
	}

	@Override
	protected String getFileFieldName() {
		return STICKER_FIELD;
	}

	@Override
	protected BoundRequestBuilder populateRequestDetails(BoundRequestBuilder requestBuilder) {
		return requestBuilder;
	}
}
