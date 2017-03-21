package ru.skuptsov.telegram.bot.platform.handler.regexp;

import com.google.common.collect.ImmutableList;
import com.google.common.eventbus.EventBus;
import org.joda.time.DateTime;
import org.kubek2k.springockito.annotations.ReplaceWithMock;
import org.kubek2k.springockito.annotations.SpringockitoAnnotatedContextLoader;
import org.kubek2k.springockito.annotations.WrapWithSpy;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.skuptsov.telegram.bot.platform.CommonTestConfiguration;
import ru.skuptsov.telegram.bot.platform.client.TelegramBotApi;
import ru.skuptsov.telegram.bot.platform.common.BaseTestMatcher;
import ru.skuptsov.telegram.bot.platform.config.BotPlatformConfiguration;
import ru.skuptsov.telegram.bot.platform.model.UpdateEvent;
import ru.skuptsov.telegram.bot.platform.model.UpdateEvents;
import ru.skuptsov.telegram.bot.platform.model.api.methods.send.SendMessage;
import ru.skuptsov.telegram.bot.platform.model.api.objects.Message;
import ru.skuptsov.telegram.bot.platform.model.api.objects.Update;
import ru.skuptsov.telegram.bot.platform.repository.UpdatesRepository;

import java.util.Objects;

import static org.joda.time.DateTimeZone.UTC;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.*;
import static ru.skuptsov.telegram.bot.platform.CommonTestConfiguration.CHAT_ID;
import static ru.skuptsov.telegram.bot.platform.handler.regexp.RegexpMessageHandler.MESSAGE_ANSWER;

/**
 * @author Sergey Kuptsov
 * @since 27/11/2016
 */
@ActiveProfiles({"test"})
@ContextConfiguration(
        classes = {
                BotPlatformConfiguration.class,
                CommonTestConfiguration.class,
                RegexpMessageHandler.class,
        },
        loader = SpringockitoAnnotatedContextLoader.class
)
public class RegexpMessageHandlerTest extends AbstractTestNGSpringContextTests {

    @Autowired
    @ReplaceWithMock
    private UpdatesRepository updatesRepository;

    @Autowired
    private EventBus eventBus;

    @Autowired
    @Qualifier("commandSenderBotApi")
    @WrapWithSpy
    private TelegramBotApi telegramBotApi;

    @BeforeMethod
    public void before() {
        Mockito.reset(telegramBotApi);
    }

    @Test
    public void sendText() throws InterruptedException {
        Update update = Mockito.mock(Update.class);
        Message message = Mockito.mock(Message.class);
        when(message.getText()).thenReturn("hi, there!");
        when(message.getChat().getId()).thenReturn(CHAT_ID);
        when(update.getMessage()).thenReturn(message);

        UpdateEvent updateEvent = new UpdateEvent(update, DateTime.now(UTC));

        eventBus.post(UpdateEvents.builder()
                .updateEventList(ImmutableList.of(updateEvent))
                .build());

        //await termination
        Thread.sleep(1000);

		SendMessage callbackMessage = SendMessage	.builder()
													.chatId(CHAT_ID.toString())
													.text(MESSAGE_ANSWER)
													.build();

        verify(telegramBotApi)
                .sendMessageAsync(argThat(new SendMessageObjectMatcher(callbackMessage)));
    }

    @Test
    public void sendTextNoAnswer() throws InterruptedException {
        Update update = Mockito.mock(Update.class);
        Message message = Mockito.mock(Message.class);
        when(message.getText()).thenReturn("Goodbye");
        when(message.getChat().getId()).thenReturn(CHAT_ID);
        when(update.getMessage()).thenReturn(message);

        UpdateEvent updateEvent = new UpdateEvent(update, DateTime.now(UTC));

        eventBus.post(UpdateEvents.builder()
                .updateEventList(ImmutableList.of(updateEvent))
                .build());

        //await termination
        Thread.sleep(1000);

		SendMessage callbackMessage = SendMessage	.builder()
													.chatId(CHAT_ID.toString())
													.text(MESSAGE_ANSWER)
													.build();

        verify(telegramBotApi, never())
                .sendMessageAsync(argThat(new SendMessageObjectMatcher(callbackMessage)));
    }

    private static class SendMessageObjectMatcher extends BaseTestMatcher<SendMessage> {

        public SendMessageObjectMatcher(SendMessage object) {
            super(object);
        }

        @Override
        protected boolean isEqual(SendMessage that) {
            return Objects.equals(that.getPath(), expected.getPath()) &&
                    Objects.equals(that.getText(), expected.getText()) &&
                    Objects.equals(that.getChatId(), expected.getChatId());
        }
    }
}
