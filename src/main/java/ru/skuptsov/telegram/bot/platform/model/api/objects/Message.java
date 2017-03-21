package ru.skuptsov.telegram.bot.platform.model.api.objects;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import ru.skuptsov.telegram.bot.platform.model.api.objects.games.Game;

@Data
public class Message {

	private static final String MESSAGEID_FIELD = "message_id";
	private static final String FORWARDFROM_FIELD = "forward_from";
	private static final String FORWARDFROMCHAT_FIELD = "forward_from_chat";
	private static final String FORWARDDATE_FIELD = "forward_date";
	private static final String PINNED_MESSAGE_FIELD = "pinned_message";
	private static final String NEWCHATMEMBER_FIELD = "new_chat_member";
	private static final String LEFTCHATMEMBER_FIELD = "left_chat_member";
	private static final String NEWCHATTITLE_FIELD = "new_chat_title";
	private static final String NEWCHATPHOTO_FIELD = "new_chat_photo";
	private static final String DELETECHATPHOTO_FIELD = "delete_chat_photo";
	private static final String GROUPCHATCREATED_FIELD = "group_chat_created";
	private static final String REPLYTOMESSAGE_FIELD = "reply_to_message";
	private static final String SUPERGROUPCREATED_FIELD = "supergroup_chat_created";
	private static final String CHANNELCHATCREATED_FIELD = "channel_chat_created";
	private static final String MIGRATETOCHAT_FIELD = "migrate_to_chat_id";
	private static final String MIGRATEFROMCHAT_FIELD = "migrate_from_chat_id";
	private static final String EDITDATE_FIELD = "edit_date";

	/**
	 * Integer Unique message identifier
	 */
	@JsonProperty(MESSAGEID_FIELD)
	private Integer messageId;

	/**
	 * Optional. Sender, can be empty for messages sent to channels
	 */
	private User from;

	/**
	 * Optional. Date the message was sent in Unix time
	 */
	private Integer date;

	/**
	 * Conversation the message belongs to
	 */
	private Chat chat;

	/**
	 * Optional. For forwarded messages, sender of the original message
	 */
	@JsonProperty(FORWARDFROM_FIELD)
	private User forwardFrom;

	/**
	 * Optional. For messages forwarded from a channel, information about the
	 * original channel
	 */
	@JsonProperty(FORWARDFROMCHAT_FIELD)
	private Chat forwardFromChat;

	/**
	 * Optional. For forwarded messages, date the original message was sent
	 */
	@JsonProperty(FORWARDDATE_FIELD)
	private Integer forwardDate;

	/**
	 * Optional. For text messages, the actual UTF-8 text of the message
	 */
	private String text;

	/**
	 * Optional. For text messages, special entities like usernames, URLs, bot
	 * commands, etc. that appear in the text
	 */
	private List<MessageEntity> entities;

	/**
	 * Optional. Message is an audio file, information about the file
	 */
	private Audio audio;

	/**
	 * Optional. Message is a general file, information about the file
	 */
	private Document document;

	/**
	 * Optional. Message is a photo, available sizes of the photo
	 */
	private List<PhotoSize> photo;

	/**
	 * Optional. Message is a sticker, information about the sticker
	 */
	private Sticker sticker;

	/**
	 * Optional. Message is a video, information about the video
	 */
	private Video video;

	/**
	 * Optional. Message is a shared contact, information about the contact
	 */
	private Contact contact;

	/**
	 * Optional. Message is a shared location, information about the location
	 */
	private Location location;

	/**
	 * Optional. Message is a venue, information about the venue
	 */
	private Venue venue;

	/**
	 * Optional. Specified message was pinned. Note that the Message object in
	 * this field will not contain further reply_to_message fields even if it is
	 * itself a reply.
	 */
	@JsonProperty(PINNED_MESSAGE_FIELD)
	private Message pinnedMessage;

	/**
	 * Optional. A new member was added to the group, information about them
	 * (this member may be bot itself)
	 */
	@JsonProperty(NEWCHATMEMBER_FIELD)
	private User newChatMember;

	/**
	 * Optional. A member was removed from the group, information about them
	 * (this member may be bot itself)
	 */
	@JsonProperty(LEFTCHATMEMBER_FIELD)
	private User leftChatMember;

	/**
	 * Optional. A chat title was changed to this value
	 */
	@JsonProperty(NEWCHATTITLE_FIELD)
	private String newChatTitle;

	/**
	 * Optional. A chat photo was change to this value
	 */
	@JsonProperty(NEWCHATPHOTO_FIELD)
	private List<PhotoSize> newChatPhoto;

	/**
	 * Optional. Informs that the chat photo was deleted
	 */
	@JsonProperty(DELETECHATPHOTO_FIELD)
	private Boolean deleteChatPhoto;

	/**
	 * Optional. Informs that the group has been created
	 */
	@JsonProperty(GROUPCHATCREATED_FIELD)
	private Boolean groupchatCreated;

	@JsonProperty(REPLYTOMESSAGE_FIELD)
	private Message replyToMessage;

	/**
	 * Optional. Message is a voice message, information about the file
	 */
	private Voice voice;

	/**
	 * Optional. Caption for the document, photo or video, 0-200 characters
	 */
	private String caption;

	/**
	 * Optional. Service message: the supergroup has been created. This field
	 * canвЂ�t be received in a message coming through updates, because bot
	 * canвЂ™t be a member of a supergroup when it is created. It can only be
	 * found in reply_to_message if someone replies to a very first message in a
	 * directly created supergroup.
	 */
	@JsonProperty(SUPERGROUPCREATED_FIELD)
	private Boolean superGroupCreated;

	/**
	 * Optional. Service message: the channel has been created. This field
	 * canвЂ�t be received in a message coming through updates, because bot
	 * canвЂ™t be a member of a channel when it is created. It can only be found
	 * in reply_to_message if someone replies to a very first message in a
	 * channel.
	 */
	@JsonProperty(CHANNELCHATCREATED_FIELD)
	private Boolean channelChatCreated;

	/**
	 * Optional. The chat has been migrated to a chat with specified identifier,
	 * not exceeding 1e13 by absolute value
	 */
	@JsonProperty(MIGRATETOCHAT_FIELD)
	private Long migrateToChatId; /// <

	/**
	 * Optional. The supergroup has been migrated from a group with the
	 * specified identifier. This number may be greater than 32 bits and some
	 * programming languages may have difficulty/silent defects in interpreting
	 * it. But it smaller than 52 bits, so a signed 64 bit integer or
	 * double-precision float type are safe for storing this identifier.
	 */
	@JsonProperty(MIGRATEFROMCHAT_FIELD)
	private Long migrateFromChatId;

	/**
	 * Optional. Date the message was last edited in Unix time
	 */
	@JsonProperty(EDITDATE_FIELD)
	private Integer editDate;

	/**
	 * Optional. Message is a game, information about the game
	 */
	private Game game;

}
