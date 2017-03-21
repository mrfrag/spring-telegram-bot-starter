package ru.skuptsov.telegram.bot.platform.client.command;

import java.util.function.Consumer;

import javax.validation.constraints.NotNull;

import ru.skuptsov.telegram.bot.platform.client.command.impl.AnswerCallbackQueryCommand;
import ru.skuptsov.telegram.bot.platform.client.command.impl.AnswerInlineQueryCommand;
import ru.skuptsov.telegram.bot.platform.client.command.impl.EditMessageCaptionCommand;
import ru.skuptsov.telegram.bot.platform.client.command.impl.EditMessageReplyMarkupCommand;
import ru.skuptsov.telegram.bot.platform.client.command.impl.EditMessageTextCommand;
import ru.skuptsov.telegram.bot.platform.client.command.impl.ForwardMessageCommand;
import ru.skuptsov.telegram.bot.platform.client.command.impl.SendAudioCommand;
import ru.skuptsov.telegram.bot.platform.client.command.impl.SendChatActionCommand;
import ru.skuptsov.telegram.bot.platform.client.command.impl.SendContactCommand;
import ru.skuptsov.telegram.bot.platform.client.command.impl.SendDocumentCommand;
import ru.skuptsov.telegram.bot.platform.client.command.impl.SendLocationCommand;
import ru.skuptsov.telegram.bot.platform.client.command.impl.SendMessageCommand;
import ru.skuptsov.telegram.bot.platform.client.command.impl.SendPhotoCommand;
import ru.skuptsov.telegram.bot.platform.client.command.impl.SendStickerCommand;
import ru.skuptsov.telegram.bot.platform.client.command.impl.SendVenueCommand;
import ru.skuptsov.telegram.bot.platform.client.command.impl.SendVideoCommand;
import ru.skuptsov.telegram.bot.platform.client.command.impl.SendVoiceCommand;
import ru.skuptsov.telegram.bot.platform.model.UpdateEvent;
import ru.skuptsov.telegram.bot.platform.model.api.methods.message.EditMessageCaption;
import ru.skuptsov.telegram.bot.platform.model.api.methods.message.EditMessageReplyMarkup;
import ru.skuptsov.telegram.bot.platform.model.api.methods.message.EditMessageText;
import ru.skuptsov.telegram.bot.platform.model.api.methods.message.ForwardMessage;
import ru.skuptsov.telegram.bot.platform.model.api.methods.query.AnswerCallbackQuery;
import ru.skuptsov.telegram.bot.platform.model.api.methods.query.AnswerInlineQuery;
import ru.skuptsov.telegram.bot.platform.model.api.methods.send.SendAudio;
import ru.skuptsov.telegram.bot.platform.model.api.methods.send.SendChatAction;
import ru.skuptsov.telegram.bot.platform.model.api.methods.send.SendContact;
import ru.skuptsov.telegram.bot.platform.model.api.methods.send.SendDocument;
import ru.skuptsov.telegram.bot.platform.model.api.methods.send.SendLocation;
import ru.skuptsov.telegram.bot.platform.model.api.methods.send.SendMessage;
import ru.skuptsov.telegram.bot.platform.model.api.methods.send.SendPhoto;
import ru.skuptsov.telegram.bot.platform.model.api.methods.send.SendSticker;
import ru.skuptsov.telegram.bot.platform.model.api.methods.send.SendVenue;
import ru.skuptsov.telegram.bot.platform.model.api.methods.send.SendVideo;
import ru.skuptsov.telegram.bot.platform.model.api.methods.send.SendVoice;

/**
 * @author Sergey Kuptsov
 * @since 24/07/2016
 *
 *        Message response to answer on chat activity
 */
public class MessageResponse {
	public final static MessageResponse EMPTY = new MessageResponse(ApiCommand.EMPTY);

	@SuppressWarnings("rawtypes")
	private final ApiCommand apiCommand;

	public MessageResponse(ApiCommand<?> apiCommand) {
		this.apiCommand = apiCommand;
	}

	@SuppressWarnings("rawtypes")
	public ApiCommand getApiCommand() {
		return apiCommand;
	}

	@SuppressWarnings("unchecked")
	public <T> MessageResponse setCallback(Consumer<T> callback) {
		apiCommand.setCallback(callback);
		return this;
	}

	public static MessageResponse fromCommand(@NotNull ApiCommand<?> apiCommand) {
		return new MessageResponse(apiCommand);
	}

	public static MessageResponse sendMessage(@NotNull String messageText, @NotNull UpdateEvent updateEvent) {
		return fromCommand(new SendMessageCommand(SendMessage.builder().chatId(getChatId(updateEvent)).text(messageText).build()));
	}

	public static MessageResponse sendMessage(@NotNull SendMessage sendMessage) {
		return fromCommand(new SendMessageCommand(sendMessage));
	}

	public static MessageResponse editMessageText(@NotNull EditMessageText editMessageText) {
		return fromCommand(new EditMessageTextCommand(editMessageText));
	}

	public static MessageResponse editMessageReplyMarkup(@NotNull EditMessageReplyMarkup editMessageReplyMarkup) {
		return fromCommand(new EditMessageReplyMarkupCommand(editMessageReplyMarkup));
	}

	public static MessageResponse sendContact(@NotNull SendContact sendContact) {
		return fromCommand(new SendContactCommand(sendContact));
	}

	public static MessageResponse sendLocation(@NotNull SendLocation message) {
		return fromCommand(new SendLocationCommand(message));
	}

	public static MessageResponse sendDocument(@NotNull SendDocument message) {
		return fromCommand(new SendDocumentCommand(message));
	}

	public static MessageResponse sendPhoto(@NotNull SendPhoto message) {
		return fromCommand(new SendPhotoCommand(message));
	}

	public static MessageResponse sendSticker(@NotNull SendSticker message) {
		return fromCommand(new SendStickerCommand(message));
	}

	public static MessageResponse sendVideo(@NotNull SendVideo message) {
		return fromCommand(new SendVideoCommand(message));
	}

	public static MessageResponse sendVoice(@NotNull SendVoice message) {
		return fromCommand(new SendVoiceCommand(message));
	}

	public static MessageResponse sendAudio(@NotNull SendAudio message) {
		return fromCommand(new SendAudioCommand(message));
	}

	public static MessageResponse answerCallbackQuery(@NotNull AnswerCallbackQuery message) {
		return fromCommand(new AnswerCallbackQueryCommand(null, message));
	}

	public static MessageResponse answerInlineQuery(@NotNull AnswerInlineQuery message) {
		return fromCommand(new AnswerInlineQueryCommand(null, message));
	}

	public static MessageResponse sendVenue(@NotNull SendVenue message) {
		return fromCommand(new SendVenueCommand(message));
	}

	public static MessageResponse editMessageCaption(@NotNull EditMessageCaption message) {
		return fromCommand(new EditMessageCaptionCommand(message));
	}

	public static MessageResponse forwardMessage(@NotNull ForwardMessage message) {
		return fromCommand(new ForwardMessageCommand(message));
	}

	public static MessageResponse sendChatAction(@NotNull SendChatAction message) {
		return fromCommand(new SendChatActionCommand(message));
	}

	private static String getChatId(@NotNull UpdateEvent updateEvent) {
		return updateEvent.getUpdate().getMessage().getChat().getId().toString();
	}
}