package ru.skuptsov.telegram.bot.platform.model.api.objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @brief Group members categories
 */
public enum MemberStatus {

	CREATOR, ADMINISTRATOR, MEMBER, LEFT, KICKED;

	@JsonCreator
	public static MemberStatus formJson(String json) {
		return valueOf(json.toUpperCase());
	}

	@JsonValue
	@Override
	public String toString() {
		return name().toLowerCase();
	}

}
