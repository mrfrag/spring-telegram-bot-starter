package ru.skuptsov.telegram.bot.platform.model.api.objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EntityType {

	MENTION, HASHTAG, BOT_COMMAND, URL, EMAIL, BOLD, ITALIC, CODE, PRE, TEXTLINK, TEXTMENTION;

	@JsonValue
	public String toJson() {
		return name().toLowerCase();
	}

	@JsonCreator
	public static EntityType fromJson(String value) {
		return valueOf(value.toUpperCase());
	}

}
