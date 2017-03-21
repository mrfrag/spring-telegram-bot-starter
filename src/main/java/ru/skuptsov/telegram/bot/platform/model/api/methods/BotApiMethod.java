package ru.skuptsov.telegram.bot.platform.model.api.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public abstract class BotApiMethod {

	protected static final String METHOD_FIELD = "method";

	@JsonProperty(METHOD_FIELD)
	private String getMethod() {
		return getClass().getSimpleName().toLowerCase();
	}

	/**
	 * Getter for method path (that is the same as method name)
	 * 
	 * @return Method path
	 */
	public String getPath() {
		return getMethod();
	}

	public void validate() {

	}

	public enum ParseModes {

		MARKDOWN, HTML;

		@JsonValue
		public String toJson() {
			return name().toLowerCase();
		}

		@JsonCreator
		public static ParseModes fromJson(String value) {
			return valueOf(value.toUpperCase());
		}

	}

}