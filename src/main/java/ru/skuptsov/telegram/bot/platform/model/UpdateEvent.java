package ru.skuptsov.telegram.bot.platform.model;

import lombok.*;
import ru.skuptsov.telegram.bot.platform.model.api.objects.Update;

import org.joda.time.DateTime;

/**
 * @author Sergey Kuptsov
 * @since 22/05/2016
 */
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateEvent {
    public final static UpdateEvent EMPTY = new UpdateEvent();

    /**
     * Original update receive from telegram
     */
    private Update update;
    /**
     * Received time
     */
    private DateTime received;
}
