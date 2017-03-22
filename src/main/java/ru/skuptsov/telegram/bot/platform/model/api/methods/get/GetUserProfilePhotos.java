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
public class GetUserProfilePhotos extends BotApiMethod {

	public static final String USERID_FIELD = "user_id";

	/**
	 * Unique identifier of the target user
	 */
	@JsonProperty(USERID_FIELD)
	private Integer userId;

	/**
	 * Sequential number of the first photo to be returned. By default, all
	 * photos are returned.
	 */
	private Integer offset;

	/**
	 * Optional. Limits the number of photos to be retrieved. Values between
	 * 1—100 are accepted. Defaults to 100.
	 */
	private Integer limit;

	@Override
	public void validate() {
		if (userId == null) {
			throw new ValidationException("UserId parameter can't be empty");
		}
		if (offset == null) {
			throw new ValidationException("Offset parameter can't be empty");
		}
	}

}
