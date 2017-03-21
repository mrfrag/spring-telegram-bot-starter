package ru.skuptsov.telegram.bot.platform.model.api.objects;

import lombok.Data;

/**
 * @brief This object represents one special entity in a text message. For
 *        example, hashtags, usernames, URL.
 */
@Data
public class MessageEntity {

	/**
	 * Type of the entity. One of mention (@username), hashtag, bot_command,
	 * url, email, bold (bold text), italic (italic text), code (monowidth
	 * string), pre (monowidth block), text_link (for clickable text URLs)
	 * text_mention (for users without usernames)
	 */
	private EntityType type;

	/**
	 * Offset in UTF-16 code units to the start of the entity
	 */
	private Integer offset;

	/**
	 * Length of the entity in UTF-16 code units
	 */
	private Integer length;

	/**
	 * Optional. For “text_link” only, url that will be opened after user
	 * taps on the text
	 */
	private String url;

	/**
	 * Optional. For “text_mention” only, the mentioned user
	 */
	private User user;

	/**
	 * Text present in the entity. Computed from offset and length
	 */
	private String text;

}
