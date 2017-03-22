package ru.skuptsov.telegram.bot.platform.model.api.methods.query;

import java.util.List;

import javax.validation.ValidationException;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.skuptsov.telegram.bot.platform.model.api.methods.BotApiMethod;
import ru.skuptsov.telegram.bot.platform.model.api.objects.inlinequery.result.InlineQueryResult;

/**
 * @brief Use this method to send answers to an inline query. On success, True
 *        is returned.
 */
@Builder
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class AnswerInlineQuery extends BotApiMethod {

	private static final String INLINEQUERYID_FIELD = "inline_query_id";
	private static final String CACHETIME_FIELD = "cache_time";
	private static final String ISPERSONAL_FIELD = "is_personal";
	private static final String NEXTOFFSET_FIELD = "next_offset";
	private static final String SWITCH_PM_TEXT_FIELD = "switch_pm_text";
	private static final String SWITCH_PM_PARAMETER_FIELD = "switch_pm_parameter";

	/**
	 * Unique identifier for answered query
	 */
	@JsonProperty(INLINEQUERYID_FIELD)
	private String inlineQueryId;

	/**
	 * A JSON-serialized array of results for the inline query
	 */
	private List<InlineQueryResult> results;

	/**
	 * Optional The maximum amount of time the result of the inline query may be
	 * cached on the server
	 */
	@JsonProperty(CACHETIME_FIELD)
	private Integer cacheTime;

	/**
	 * Pass True, if results may be cached on the server side only for the user
	 * that sent the query. By default, results may be returned to any user who
	 * sends the same query
	 */
	@JsonProperty(ISPERSONAL_FIELD)
	private Boolean isPersonal;

	/**
	 * Optional. Pass the offset that a client should send in the next query
	 * with the same text to receive more results. Pass an empty string if there
	 * are no more results or if you donвЂ�t support pagination. Offset length
	 * canвЂ™t exceed 64 bytes.
	 */
	@JsonProperty(NEXTOFFSET_FIELD)
	private String nextOffset;

	/**
	 * Optional. If passed, clients will display a button with specified text
	 * that switches the user to a private chat with the bot and sends the bot a
	 * start message with the parameter switch_pm_parameter
	 */
	@JsonProperty(SWITCH_PM_TEXT_FIELD)
	private String switchPmText;

	/**
	 * Optional. Parameter for the start message sent to the bot when user
	 * presses the switch button
	 */
	@JsonProperty(SWITCH_PM_PARAMETER_FIELD)
	private String switchPmParameter;

	@Override
	public void validate() {
		if (inlineQueryId == null) {
			throw new ValidationException("InlineQueryId can't be empty");
		}
		if (results == null) {
			throw new ValidationException("Results array can't be null");
		}
		results.forEach(InlineQueryResult::validate);
	}

}
