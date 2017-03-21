package ru.skuptsov.telegram.bot.platform.client;

import java.util.concurrent.Future;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.JavaType;

import ru.skuptsov.telegram.bot.platform.client.exception.TelegramBotApiException;
import ru.skuptsov.telegram.bot.platform.model.api.methods.BotApiMethod;

/**
 * @author Sergey Kuptsov
 * @since 22/05/2016
 */
public interface TelegramBotHttpClient {

    <T, V extends BotApiMethod> Future<T> executeMethod(
            @Nullable V requestObject,
            @NotNull JavaType returnType) throws TelegramBotApiException;
}
