package ru.skuptsov.telegram.bot.platform.callback;

import ru.skuptsov.telegram.bot.platform.model.api.objects.Message;

/**
 * @author Sergey Kuptsov
 * @since 30/11/2016
 */
public interface CallbackMethod {
    void run(Message message);
}
