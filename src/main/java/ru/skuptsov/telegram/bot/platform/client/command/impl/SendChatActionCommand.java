package ru.skuptsov.telegram.bot.platform.client.command.impl;

import java.util.concurrent.Future;
import java.util.function.Consumer;

import lombok.Getter;
import lombok.ToString;
import ru.skuptsov.telegram.bot.platform.client.TelegramBotApi;
import ru.skuptsov.telegram.bot.platform.model.api.methods.send.SendChatAction;

/**
 * 
 * @author mrfrag
 *
 */
@Getter
@ToString
public class SendChatActionCommand extends AbstractApiCommand<Boolean> {

	private SendChatAction message;

	public SendChatActionCommand(Consumer<Boolean> callback, SendChatAction message) {
		super(callback);
		this.message = message;
	}

	public SendChatActionCommand(SendChatAction message) {
		super(null);
		this.message = message;
	}

	@Override
	public Future<Boolean> execute(TelegramBotApi telegramBotApi) {
		return telegramBotApi.sendChatAction(message.getChatId(), message.getAction());
	}

}
