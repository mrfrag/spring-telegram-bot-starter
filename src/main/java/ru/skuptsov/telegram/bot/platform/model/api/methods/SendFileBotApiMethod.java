package ru.skuptsov.telegram.bot.platform.model.api.methods;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ning.http.client.AsyncHttpClient.BoundRequestBuilder;
import com.ning.http.client.multipart.FilePart;
import com.ning.http.client.multipart.StringPart;

import ru.skuptsov.telegram.bot.platform.model.api.objects.replykeyboard.ReplyKeyboard;

public abstract class SendFileBotApiMethod extends SendBotApiMethod {

	@JsonIgnore
	private File file;

	protected SendFileBotApiMethod(String chatId, Integer replyToMessageId, Boolean disableNotification, ReplyKeyboard replyMarkup, File file) {
		super(chatId, replyToMessageId, disableNotification, replyMarkup);
		this.file = file;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@JsonIgnore
	public boolean isNewFile() {
		return file != null;
	}

	@JsonIgnore
	protected abstract String getFileFieldName();

	public final BoundRequestBuilder populateRequest(BoundRequestBuilder requestBuilder) {
		return populateRequestDetails(requestBuilder.addBodyPart(new StringPart(CHATID_FIELD, getChatId()))
													.addBodyPart(new FilePart(getFileFieldName(), file)));
	}

	protected abstract BoundRequestBuilder populateRequestDetails(BoundRequestBuilder requestBuilder);

}
