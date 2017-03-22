package ru.skuptsov.telegram.bot.platform.model.api.methods.get;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.skuptsov.telegram.bot.platform.model.api.methods.BotApiMethod;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class GetUpdates extends BotApiMethod {

	private Integer offset;

	private Integer timeout;

	private Integer limit;

}
