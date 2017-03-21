package ru.skuptsov.telegram.bot.platform.handler.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.skuptsov.telegram.bot.platform.handler.CallbackQueryDataMessageHandler;
import ru.skuptsov.telegram.bot.platform.model.UpdateEvent;
import ru.skuptsov.telegram.bot.platform.model.api.objects.CallbackQuery;

import java.util.List;
import java.util.Set;

import static java.util.Optional.ofNullable;

/**
 * @author Sergey Kuptsov
 * @since 06/06/2016
 */
@Component
public class CallbackQueryDataMessageHandlerResolver extends AbstractMessageContentMessageHandlerResolver {

    @Autowired(required = false)
    public CallbackQueryDataMessageHandlerResolver(List<CallbackQueryDataMessageHandler> callbackQueryDataMessageHandlers) {
        callbackQueryDataMessageHandlers.stream().forEach(this::add);
    }

    public CallbackQueryDataMessageHandlerResolver() {
    }

    public void add(CallbackQueryDataMessageHandler callbackQueryDataMessageHandler) {
        Set<String> commandTextList = callbackQueryDataMessageHandler.getCallbackQueryData();
        for (String data : commandTextList) {
            add(data, callbackQueryDataMessageHandler);
        }
    }

    @Override
    protected Object getMessageContent(UpdateEvent updateEvent) {
        return ofNullable(updateEvent.getUpdate().getCallbackQuery())
                .map(CallbackQuery::getData)
                .orElse("");
    }
}
