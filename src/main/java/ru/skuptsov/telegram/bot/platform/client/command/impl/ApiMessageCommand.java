package ru.skuptsov.telegram.bot.platform.client.command.impl;

import java.util.concurrent.Future;
import java.util.function.Consumer;

import javax.validation.constraints.NotNull;

import ru.skuptsov.telegram.bot.platform.client.TelegramBotApi;
import ru.skuptsov.telegram.bot.platform.model.api.methods.BotApiMethod;
import ru.skuptsov.telegram.bot.platform.model.api.objects.Message;

/**
 * @author Sergey Kuptsov
 * @since 13/08/2016
 */
public abstract class ApiMessageCommand<T extends BotApiMethod> extends AbstractApiCommand<Message> {

	private final T message;

	public ApiMessageCommand(Consumer<Message> callback, T message) {
		super(callback);
		this.message = message;
	}

	public ApiMessageCommand(T message) {
		super(null);
		this.message = message;
	}

	@Override
	public Future<Message> execute(@NotNull TelegramBotApi telegramBotApi) {
		return telegramBotApi.sendMessageAsync(message);
	}

}
