package ru.skuptsov.telegram.bot.platform.model.api.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Video {

	private static final String FILEID_FIELD = "file_id";
	private static final String MIMETYPE_FIELD = "mime_type";
	private static final String FILESIZE_FIELD = "file_size";

	/**
	 * Unique identifier for this file
	 */
	@JsonProperty(FILEID_FIELD)
	private String fileId;

	/**
	 * Video width as defined by sender
	 */
	private Integer width;

	/**
	 * Video height as defined by sender
	 */
	private Integer height;

	/**
	 * Duration of the video in seconds as defined by sender
	 */
	private Integer duration;

	/**
	 * Video thumbnail
	 */
	private PhotoSize thumb;

	/**
	 * Optional. Mime type of a file as defined by sender
	 */
	@JsonProperty(MIMETYPE_FIELD)
	private String mimeType;

	/**
	 * Optional. File size
	 */
	@JsonProperty(FILESIZE_FIELD)
	private Integer fileSize;

}
