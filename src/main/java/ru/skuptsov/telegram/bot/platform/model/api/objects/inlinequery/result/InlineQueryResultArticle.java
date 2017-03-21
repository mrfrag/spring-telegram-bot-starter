package ru.skuptsov.telegram.bot.platform.model.api.objects.inlinequery.result;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.skuptsov.telegram.bot.platform.model.api.objects.inlinequery.inputmessagecontent.InputMessageContent;
import ru.skuptsov.telegram.bot.platform.model.api.objects.replykeyboard.InlineKeyboardMarkup;

/**
 * @brief Represents a link to an article or web page.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class InlineQueryResultArticle extends InlineQueryResult {

	private static final String URL_FIELD = "url";
	private static final String HIDEURL_FIELD = "hide_url";
	private static final String DESCRIPTION_FIELD = "description";

	@Builder
	private InlineQueryResultArticle(String id, String title, InputMessageContent inputMessageContent, InlineKeyboardMarkup replyMarkup, String thumbUrl, Integer thumbWidth, Integer thumbHeight, String url, Boolean hideUrl,
			String description) {
		super(id, title, inputMessageContent, replyMarkup, thumbUrl, thumbWidth, thumbHeight);
		this.url = url;
		this.hideUrl = hideUrl;
		this.description = description;
	}

	/**
	 * Optional. URL of the result
	 */
	@JsonProperty(URL_FIELD)
	private String url;

	/**
	 * Optional. Pass True, if you don't want the URL to be shown in the message
	 */
	@JsonProperty(HIDEURL_FIELD)
	private Boolean hideUrl;

	/**
	 * Optional. Short description of the result
	 */
	@JsonProperty(DESCRIPTION_FIELD)
	private String description;

}
