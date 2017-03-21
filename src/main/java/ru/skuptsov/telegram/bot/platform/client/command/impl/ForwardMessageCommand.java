package ru.skuptsov.telegram.bot.platform.client.command.impl;

import lombok.Getter;
import lombok.ToString;
import ru.skuptsov.telegram.bot.platform.model.api.methods.message.ForwardMessage;

/**
 * @author Sergey Kuptsov
 * @since 02/06/2016
 */
@Getter
@ToString
public class ForwardMessageCommand extends ApiMessageCommand<ForwardMessage> {

	public ForwardMessageCommand(ForwardMessage command) {
		super(command);
	}
}
