package ru.skuptsov.telegram.bot.platform.client.command.impl;

import lombok.Getter;
import lombok.ToString;
import ru.skuptsov.telegram.bot.platform.model.api.methods.message.EditMessageText;

/**
 * @author Sergey Kuptsov
 * @since 02/06/2016
 */
@Getter
@ToString
public class EditMessageTextCommand extends ApiMessageCommand<EditMessageText> {

	public EditMessageTextCommand(EditMessageText message) {
		super(message);
	}
}
