package ru.skuptsov.telegram.bot.platform.model.api.objects;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @brief This object represent a user's profile pictures.
 */
@Data
public class UserProfilePhotos {

	private static final String TOTALCOUNT_FIELD = "total_count";

	/**
	 * Total number of profile pictures the target user has
	 */
	@JsonProperty(TOTALCOUNT_FIELD)
	private Integer totalCount;

	/**
	 * Requested profile pictures (in up to 4 sizes each)
	 */
	private List<List<PhotoSize>> photos;

}
