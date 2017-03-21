package ru.skuptsov.telegram.bot.platform.model.api.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Document {

	private static final String FILEID_FIELD = "file_id";
	private static final String THUMB_FIELD = "thumb";
	private static final String FILENAME_FIELD = "file_name";
	private static final String MIMETYPE_FIELD = "mime_type";
	private static final String FILESIZE_FIELD = "file_size";

	/**
	 * Unique identifier for this file
	 */
	@JsonProperty(FILEID_FIELD)
	private String fileId;

	/**
	 * Document thumbnail as defined by sender
	 */
	@JsonProperty(THUMB_FIELD)
	private PhotoSize thumb;

	/**
	 * Optional. Original filename as defined by sender
	 */
	@JsonProperty(FILENAME_FIELD)
	private String fileName;

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
