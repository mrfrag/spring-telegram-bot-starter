package ru.skuptsov.telegram.bot.platform.model.api.methods.get;

import javax.validation.ValidationException;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import ru.skuptsov.telegram.bot.platform.model.api.methods.BotApiMethod;

@Builder
@AllArgsConstructor
public class GetFile extends BotApiMethod {

	private static final String FILEID_FIELD = "file_id";

	/**
	 * File identifier to get info about
	 */
	@JsonProperty(FILEID_FIELD)
	private String fileId;

	public GetFile() {
		super();
	}

	public String getFileId() {
		return fileId;
	}

	public GetFile setFileId(String fileId) {
		this.fileId = fileId;
		return this;
	}

	@Override
	public void validate() {
		if (fileId == null) {
			throw new ValidationException("FileId can't be empty");
		}
	}

	@Override
	public String toString() {
		return "GetFile{" +
				"fileId='" + fileId + '\'' +
				'}';
	}
}
