package ru.skuptsov.telegram.bot.platform.client.command.impl;

import lombok.Getter;
import lombok.ToString;
import ru.skuptsov.telegram.bot.platform.model.api.methods.send.SendMessage;

/**
 * @author Sergey Kuptsov
 * @since 02/06/2016
 */
@Getter
@ToString
public class SendMessageCommand extends ApiMessageCommand<SendMessage> {

	public SendMessageCommand(SendMessage command) {
		super(command);
	}
}
