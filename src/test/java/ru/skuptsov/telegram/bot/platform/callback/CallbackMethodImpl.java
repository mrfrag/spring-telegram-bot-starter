package ru.skuptsov.telegram.bot.platform.callback;

import org.springframework.stereotype.Component;

import ru.skuptsov.telegram.bot.platform.model.api.objects.Message;

/**
 * @author Sergey Kuptsov
 * @since 30/11/2016
 */
@Component
public class CallbackMethodImpl implements CallbackMethod {

    @Override
    public void run(Message message) {

    }
}
