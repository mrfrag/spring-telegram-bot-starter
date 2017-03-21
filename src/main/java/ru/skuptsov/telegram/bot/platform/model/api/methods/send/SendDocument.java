package ru.skuptsov.telegram.bot.platform.model.api.methods.send;

import java.io.File;
import java.nio.charset.Charset;

import com.ning.http.client.AsyncHttpClient.BoundRequestBuilder;
import com.ning.http.client.multipart.StringPart;

import lombok.Builder;
import ru.skuptsov.telegram.bot.platform.model.api.methods.SendFileBotApiMethod;
import ru.skuptsov.telegram.bot.platform.model.api.objects.replykeyboard.ReplyKeyboard;

public class SendDocument extends SendFileBotApiMethod {

	public static final String DOCUMENT_FIELD = "document";
	public static final String CAPTION_FIELD = "caption";

	/**
	 * File file to send. file_id as String to resend a file that is already on
	 * the Telegram servers
	 */
	private String document;

	/**
	 * Optional. Document caption (may also be used when resending documents by
	 * file_id), 0-200 characters
	 */
	private String caption;

	@Builder
	private SendDocument(String chatId, Integer replyToMessageId, Boolean disableNotification, ReplyKeyboard replyMarkup, File file, String document, String caption) {
		super(chatId, replyToMessageId, disableNotification, replyMarkup, file);
		this.document = document;
		this.caption = caption;
	}

	public String getDocument() {
		return document;
	}

	/**
	 * Use this method to set the document to an document existing in Telegram
	 * system
	 *
	 * @param document
	 *            File_id of the document to send
	 * @note The file_id must have already been received or sent by your bot
	 */
	public void setDocument(String document) {
		this.document = document;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	@Override
	protected String getFileFieldName() {
		return DOCUMENT_FIELD;
	}

	@Override
	protected BoundRequestBuilder populateRequestDetails(BoundRequestBuilder requestBuilder) {
		return requestBuilder.addBodyPart(new StringPart(CAPTION_FIELD, caption, "text/plain", Charset.forName("utf-8")));
	}

}
