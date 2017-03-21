package ru.skuptsov.telegram.bot.platform.handler.registry.proxy;

import javax.validation.constraints.NotNull;

import com.google.common.base.Preconditions;

import ru.skuptsov.telegram.bot.platform.handler.ConditionMessageHandler;
import ru.skuptsov.telegram.bot.platform.handler.annotation.MessageFilter;
import ru.skuptsov.telegram.bot.platform.model.UpdateEvent;

/**
 * @author Sergey Kuptsov
 * @since 24/07/2016
 */
//todo: message filter
//@Component
//@Scope(value = SCOPE_PROTOTYPE)
public class ConditionalEventMessageHandlerProxy extends BaseMessageHandlerProxy implements ConditionMessageHandler {

	private final MessageFilter messageFilter;

	public ConditionalEventMessageHandlerProxy(HandlerMethod handlerMethod, @NotNull MessageFilter messageFilter) {
		super(handlerMethod);
		Preconditions.checkNotNull(messageFilter, "Message filter cannot be null");
		this.messageFilter = messageFilter;
	}

	@Override
	public boolean isSuitableForProcessingEvent(@NotNull UpdateEvent updateEvent) {
		return messageFilter.test(updateEvent);
	}
}
