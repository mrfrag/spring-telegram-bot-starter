package ru.skuptsov.telegram.bot.platform.model.api.methods.send;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ru.skuptsov.telegram.bot.platform.config.TelegramBotClientConfiguration;
import ru.skuptsov.telegram.bot.platform.model.api.methods.BotApiMethod.ParseModes;

public class SendMessageTest {

	private ObjectMapper objectMapper;

	@BeforeClass
	public void setup() {
		TelegramBotClientConfiguration configuration = new TelegramBotClientConfiguration();
		objectMapper = configuration.getObjectMapper();
	}

	@Test
	public void testSendMessageSerialization() throws JsonProcessingException {
		SendMessage method = SendMessage.builder().chatId("1").parseMode(ParseModes.MARKDOWN).text("Some text").build();

		Assert.assertEquals(objectMapper.writeValueAsString(method), "{\"text\":\"Some text\",\"path\":\"sendmessage\",\"chat_id\":\"1\",\"parse_mode\":\"markdown\",\"method\":\"sendmessage\"}");
	}

}
