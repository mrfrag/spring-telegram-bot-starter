package ru.skuptsov.telegram.bot.platform.model.api.methods.get;

import javax.validation.ValidationException;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.skuptsov.telegram.bot.platform.model.api.methods.BotApiMethod;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetFile extends BotApiMethod {

	private static final String FILEID_FIELD = "file_id";

	/**
	 * File identifier to get info about
	 */
	@JsonProperty(FILEID_FIELD)
	private String fileId;

	@Override
	public void validate() {
		if (fileId == null) {
			throw new ValidationException("FileId can't be empty");
		}
	}

}
