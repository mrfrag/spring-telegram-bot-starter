package ru.skuptsov.telegram.bot.platform.handler;

import static java.util.Optional.ofNullable;

import java.util.function.Function;

import ru.skuptsov.telegram.bot.platform.model.UpdateEvent;
import ru.skuptsov.telegram.bot.platform.model.api.objects.Message;

/**
 * @author Sergey Kuptsov
 * @since 04/07/2016
 */
public interface UpdateFunctions {

    Function<UpdateEvent, String> MESSAGE_TEXT_FROM_UPDATE_EVENT =
            updateEvent ->
                    ofNullable(updateEvent.getUpdate().getMessage())
                            .map(Message::getText)
                            .orElse("");
}



