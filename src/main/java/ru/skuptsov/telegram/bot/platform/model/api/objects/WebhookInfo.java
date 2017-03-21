package ru.skuptsov.telegram.bot.platform.model.api.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @brief Contains information about the current status of a webhook.
 */
@Data
public class WebhookInfo {

	private static final String HASCUSTOMCERTIFICATE_FIELD = "has_custom_certificate";
	private static final String PENDINGUPDATESCOUNT_FIELD = "pending_updates_count";
	private static final String LASTERRORDATE_FIELD = "last_error_date";
	private static final String LASTERRORMESSAGE_FIELD = "last_error_message";

	/**
	 * Webhook URL, may be empty if webhook is not set up
	 */
	private String url;

	/**
	 * True, if a custom certificate was provided for webhook certificate checks
	 */
	@JsonProperty(HASCUSTOMCERTIFICATE_FIELD)
	private Boolean hasCustomCertificate;

	/**
	 * Number updates awaiting delivery
	 */
	@JsonProperty(PENDINGUPDATESCOUNT_FIELD)
	private Integer pendingUpdatesCount;

	/**
	 * Optional. Unix time for the most recent error that happened when trying
	 * to deliver an update via webhook
	 */
	@JsonProperty(LASTERRORDATE_FIELD)
	private Integer lastErrorDate;

	/**
	 * Optional. Error message in human-readable format for the most recent
	 * error that happened when trying to deliver an update via webhook
	 */
	@JsonProperty(LASTERRORMESSAGE_FIELD)
	private String lastErrorMessage;

}
