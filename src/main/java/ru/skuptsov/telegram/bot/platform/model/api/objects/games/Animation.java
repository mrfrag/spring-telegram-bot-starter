package ru.skuptsov.telegram.bot.platform.model.api.objects.games;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import ru.skuptsov.telegram.bot.platform.model.api.objects.PhotoSize;

/**
 * @brief This object represents an animation file.
 */
@Data
public class Animation {
	private static final String FILEID_FIELD = "file_id";
	private static final String FILENAME_FIELD = "file_name";
	private static final String MIMETYPE_FIELD = "mime_type";
	private static final String FILESIZE_FIELD = "file_size";

	/**
	 * Unique file identifier
	 */
	@JsonProperty(FILEID_FIELD)
	private String fileId;

	/**
	 * Optional. Animation thumbnail as defined by sender
	 */
	private PhotoSize thumb;

	/**
	 * Optional. Original animation filename as defined by sender
	 */
	@JsonProperty(FILENAME_FIELD)
	private String fileName;

	/**
	 * Optional. MIME type of the file as defined by sender
	 */
	@JsonProperty(MIMETYPE_FIELD)
	private String mimetype;

	/**
	 * Optional. File size
	 */
	@JsonProperty(FILESIZE_FIELD)
	private Integer fileSize;

}
