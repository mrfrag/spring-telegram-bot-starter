package ru.skuptsov.telegram.bot.platform.model.api.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Sticker {

	private static final String FILEID_FIELD = "file_id";
	private static final String FILESIZE_FIELD = "file_size";

	/**
	 * Unique identifier for this file
	 */
	@JsonProperty(FILEID_FIELD)
	private String fileId;

	/**
	 * Sticker width
	 */
	private Integer width;

	/**
	 * Sticker height
	 */
	private Integer height;

	/**
	 * Optional. Sticker thumbnail in .webp or .jpg format
	 */
	private PhotoSize thumb;

	/**
	 * Optional. File size
	 */
	@JsonProperty(FILESIZE_FIELD)
	private Integer fileSize;

	/**
	 * Optional. Emoji associated with the sticker
	 */
	private String emoji;

}
