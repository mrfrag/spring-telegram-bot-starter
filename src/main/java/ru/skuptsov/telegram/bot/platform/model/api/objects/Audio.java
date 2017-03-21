package ru.skuptsov.telegram.bot.platform.model.api.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Audio {

	private static final String FILEID_FIELD = "file_id";
	private static final String DURATION_FIELD = "duration";
	private static final String MIMETYPE_FIELD = "mime_type";
	private static final String FILESIZE_FIELD = "file_size";
	private static final String TITLE_FIELD = "title";
	private static final String PERFORMER_FIELD = "performer";

	/**
	 * Unique identifier for this file
	 */
	@JsonProperty(FILEID_FIELD)
	private String fileId;

	/**
	 * Integer Duration of the audio in seconds as defined by sender
	 */
	@JsonProperty(DURATION_FIELD)
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

	/**
	 * Optional. Title of the audio as defined by sender or by audio tags
	 */
	@JsonProperty(TITLE_FIELD)
	private String title;

	/**
	 * Optional. Performer of the audio as defined by sender or by audio tags
	 */
	@JsonProperty(PERFORMER_FIELD)
	private String performer;

}
