package ru.skuptsov.telegram.bot.platform.model.api.objects.inlinequery.result;

import javax.validation.ValidationException;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.skuptsov.telegram.bot.platform.model.api.objects.inlinequery.inputmessagecontent.InputMessageContent;
import ru.skuptsov.telegram.bot.platform.model.api.objects.replykeyboard.InlineKeyboardMarkup;

/**
 * @brief Represents a link to a sticker stored on the Telegram servers. By
 *        default, this sticker will be sent by the user. Alternatively, you can
 *        use input_message_content to send a message with the specified content
 *        instead of the sticker.
 * @note This will only work in Telegram versions released after 9 April, 2016.
 *       Older clients will ignore them.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class InlineQueryResultSticker extends InlineQueryResult {

	private static final String STICKER_FILE_ID_FIELD = "sticker_file_id";

	@Builder
	private InlineQueryResultSticker(String id, String title, InputMessageContent inputMessageContent, InlineKeyboardMarkup replyMarkup, String thumbUrl, Integer thumbWidth, Integer thumbHeight, String stickerFileId) {
		super(id, title, inputMessageContent, replyMarkup, thumbUrl, thumbWidth, thumbHeight);
		this.stickerFileId = stickerFileId;
	}

	/**
	 * A valid file identifier of the sticker
	 */
	@JsonProperty(STICKER_FILE_ID_FIELD)
	private String stickerFileId;

	@Override
	public void validate() {
		super.validate();
		if (stickerFileId == null || stickerFileId.isEmpty()) {
			throw new ValidationException("StickerFileId parameter can't be empty");
		}
	}

}
