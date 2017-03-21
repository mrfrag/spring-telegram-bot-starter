package ru.skuptsov.telegram.bot.platform.model.api.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @brief This object represents one size of a photo or a file / sticker
 *        thumbnail.
 */
@Data
public class PhotoSize {

	private static final String FILEID_FIELD = "file_id";
	private static final String FILESIZE_FIELD = "file_size";
	private static final String FILEPATH_FIELD = "file_path";

	/**
	 * Unique identifier for this file
	 */
	@JsonProperty(FILEID_FIELD)
	private String fileId;

	/**
	 * Photo width
	 */
	private Integer width;

	/**
	 * Photo height
	 */
	private Integer height;

	/**
	 * Optional. File size
	 */
	@JsonProperty(FILESIZE_FIELD)
	private Integer fileSize;

	/**
	 * Undocumented field. Optional. Can contain the path to download the file
	 * direclty without calling to getFile
	 */
	@JsonProperty(FILEPATH_FIELD)
	private String filePath;

}
