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
 * @brief Represents a link to a file. By default, this file will be sent by the
 *        user with an optional caption. Alternatively, you can use
 *        input_message_content to send a message with the specified content
 *        instead of the file.
 * @note Currently, only .PDF and .ZIP files can be sent using this method.
 * @note This will only work in Telegram versions released after 9 April, 2016.
 *       Older clients will ignore them.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class InlineQueryResultDocument extends InlineQueryResult {

	private static final String DOCUMENTURL_FIELD = "document_url";
	private static final String MIMETYPE_FIELD = "mime_type";
	private static final String DOCUMENT_FILE_ID_FIELD = "document_file_id";

	@Builder
	private InlineQueryResultDocument(String id, String title, InputMessageContent inputMessageContent, InlineKeyboardMarkup replyMarkup, String thumbUrl, Integer thumbWidth, Integer thumbHeight, String documentUrl, String mimeType,
			String description, String caption, String documentFileId) {
		super(id, title, inputMessageContent, replyMarkup, thumbUrl, thumbWidth, thumbHeight);
		this.documentUrl = documentUrl;
		this.mimeType = mimeType;
		this.description = description;
		this.caption = caption;
		this.documentFileId = documentFileId;
	}

	/**
	 * A valid URL for the file
	 */
	@JsonProperty(DOCUMENTURL_FIELD)
	private String documentUrl;

	/**
	 * Mime type of the content of the file, either “application/pdf” or
	 * “application/zip”
	 */
	@JsonProperty(MIMETYPE_FIELD)
	private String mimeType;

	/**
	 * Optional. Short description of the result
	 */
	private String description;

	/**
	 * Optional. Caption of the document to be sent, 0-200 characters
	 */
	private String caption;

	/**
	 * A valid file identifier for the file
	 */
	@JsonProperty(DOCUMENT_FILE_ID_FIELD)
	private String documentFileId;

	@Override
	public void validate() {
		super.validate();
		if (mimeType == null || mimeType.isEmpty()) {
			throw new ValidationException("Mimetype parameter can't be empty");
		}
		if (documentUrl == null || documentUrl.isEmpty()) {
			throw new ValidationException("DocumentUrl parameter can't be empty");
		}
	}

	@JsonIgnore
	public boolean isCached() {
		return documentFileId != null;
	}

}
