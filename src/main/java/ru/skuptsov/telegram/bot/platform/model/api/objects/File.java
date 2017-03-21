package ru.skuptsov.telegram.bot.platform.model.api.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @version 1.0
 * @brief This object represents a file ready to be downloaded
 * @date 24 of June of 2015
 */
@Data
public class File {

	public static final String FILEBASEURL = "https://api.telegram.org/file/bot{0}/{1}";

	private static final String FILE_ID = "file_id";
	private static final String FILE_SIZE_FIELD = "file_size";
	private static final String FILE_PATH_FIELD = "file_path";

	/**
	 * Unique identifier for this file
	 */
	@JsonProperty(FILE_ID)
	private String fileId;

	/**
	 * Optional. File size, if known
	 */
	@JsonProperty(FILE_SIZE_FIELD)
	private Integer fileSize;

	/**
	 * Optional. File path. Use
	 * https://api.telegram.org/file/bot<token>/<file_path> to get the file.
	 */
	@JsonProperty(FILE_PATH_FIELD)
	private String filePath;

	@Override
	public String toString() {
		return "File{" +
				"fileId='" + fileId + '\'' +
				", fileSize=" + fileSize +
				", filePath='" + filePath + '\'' +
				'}';
	}
}
