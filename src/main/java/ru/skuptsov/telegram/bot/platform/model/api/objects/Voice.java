package ru.skuptsov.telegram.bot.platform.model.api.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @brief This object represents a voice note
 */
@Data
public class Voice {
	private static final String FILEID_FIELD = "file_id";
	private static final String MIMETYPE_FIELD = "mime_type";
	private static final String FILESIZE_FIELD = "file_size";

	/**
	 * Unique identifier for this file
	 */
	@JsonProperty(FILEID_FIELD)
	private String fileId;

	/**
	 * Integer Duration of the audio in seconds as defined by sender
	 */
	private Integer duration;

	/**
	 * Optional. MIME type of the file as defined by sender
	 */
	@JsonProperty(MIMETYPE_FIELD)
	private String mimeType;

	/**
	 * Optional. File size
	 */
	@JsonProperty(FILESIZE_FIELD)
	private Integer fileSize;

}
