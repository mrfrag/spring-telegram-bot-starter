package ru.skuptsov.telegram.bot.platform.model.api.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Chat {

	private static final String ID_FIELD = "id";
	private static final String TYPE_FIELD = "type";
	private static final String TITLE_FIELD = "title";
	private static final String FIRSTNAME_FIELD = "first_name";
	private static final String LASTNAME_FIELD = "last_name";
	private static final String USERNAME_FIELD = "username";
	private static final String ALL_MEMBERS_ARE_ADMINISTRATORS_FIELD = "all_members_are_administrators";

	/**
	 * Unique identifier for this chat. This number may be greater than 32 bits
	 * and some programming languages may have difficulty/silent defects in
	 * interpreting it. But it smaller than 52 bits, so a signed 64 bit integer
	 * or double-precision float type are safe for storing this identifier.
	 */
	@JsonProperty(ID_FIELD)
	private Long id;

	/**
	 * Type of the chat, one of вЂњprivateвЂќ, вЂњgroupвЂќ or вЂњchannelвЂќ
	 */
	@JsonProperty(TYPE_FIELD)
	private String type;

	/**
	 * Optional. Title of the chat, only for channels and group chat
	 */
	@JsonProperty(TITLE_FIELD)
	private String title;

	/**
	 * Optional. Username of the chat, only for private chats and channels if
	 * available
	 */
	@JsonProperty(FIRSTNAME_FIELD)
	private String firstName;

	/**
	 * Optional. Interlocutor's first name for private chats
	 */
	@JsonProperty(LASTNAME_FIELD)
	private String lastName;

	/**
	 * Optional. Interlocutor's last name for private chats
	 */
	@JsonProperty(USERNAME_FIELD)
	private String userName;

	/**
	 * Optional. True if the group or supergroup has вЂ�All Members Are
	 * AdminsвЂ™ enabled.
	 */
	@JsonProperty(ALL_MEMBERS_ARE_ADMINISTRATORS_FIELD)
	private Boolean allMembersAreAdministrators;

}
