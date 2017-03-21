package ru.skuptsov.telegram.bot.platform.model.api.objects;

import lombok.Data;

@Data
public class ChatMember {

	/**
	 * Information about the user
	 */
	private User user;

	/**
	 * The member's status in the chat. Can be “creator”,
	 * “administrator”, “member”, “left” or “kicked”
	 */
	private MemberStatus status;

}
