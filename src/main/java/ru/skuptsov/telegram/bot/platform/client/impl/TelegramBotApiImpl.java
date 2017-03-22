package ru.skuptsov.telegram.bot.platform.client.impl;

import static java.util.Comparator.comparingInt;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static ru.skuptsov.telegram.bot.platform.client.utils.JavaTypeUtils.listTypeOf;
import static ru.skuptsov.telegram.bot.platform.client.utils.JavaTypeUtils.simpleTypeOf;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ru.skuptsov.telegram.bot.platform.client.NextOffsetStrategy;
import ru.skuptsov.telegram.bot.platform.client.TelegramBotApi;
import ru.skuptsov.telegram.bot.platform.client.TelegramBotHttpClient;
import ru.skuptsov.telegram.bot.platform.model.api.methods.BotApiMethod;
import ru.skuptsov.telegram.bot.platform.model.api.methods.chat.KickChatMember;
import ru.skuptsov.telegram.bot.platform.model.api.methods.chat.LeaveChat;
import ru.skuptsov.telegram.bot.platform.model.api.methods.chat.UnbanChatMember;
import ru.skuptsov.telegram.bot.platform.model.api.methods.get.GetChat;
import ru.skuptsov.telegram.bot.platform.model.api.methods.get.GetChatAdministrators;
import ru.skuptsov.telegram.bot.platform.model.api.methods.get.GetChatMembersCount;
import ru.skuptsov.telegram.bot.platform.model.api.methods.get.GetFile;
import ru.skuptsov.telegram.bot.platform.model.api.methods.get.GetMe;
import ru.skuptsov.telegram.bot.platform.model.api.methods.get.GetUpdates;
import ru.skuptsov.telegram.bot.platform.model.api.methods.get.GetUserProfilePhotos;
import ru.skuptsov.telegram.bot.platform.model.api.methods.query.AnswerCallbackQuery;
import ru.skuptsov.telegram.bot.platform.model.api.methods.query.AnswerInlineQuery;
import ru.skuptsov.telegram.bot.platform.model.api.methods.send.SendChatAction;
import ru.skuptsov.telegram.bot.platform.model.api.methods.send.SendChatAction.ActionTypes;
import ru.skuptsov.telegram.bot.platform.model.api.objects.Chat;
import ru.skuptsov.telegram.bot.platform.model.api.objects.ChatMember;
import ru.skuptsov.telegram.bot.platform.model.api.objects.File;
import ru.skuptsov.telegram.bot.platform.model.api.objects.Message;
import ru.skuptsov.telegram.bot.platform.model.api.objects.Update;
import ru.skuptsov.telegram.bot.platform.model.api.objects.User;
import ru.skuptsov.telegram.bot.platform.model.api.objects.UserProfilePhotos;

/**
 * @author Sergey Kuptsov
 * @since 22/05/2016
 */
public class TelegramBotApiImpl implements TelegramBotApi {
	private final Logger log = LoggerFactory.getLogger(TelegramBotApiImpl.class);

	private final TelegramBotHttpClient client;

	@Autowired
	private NextOffsetStrategy nextOffsetStrategy;

	public TelegramBotApiImpl(TelegramBotHttpClient client) {
		this.client = client;
	}

	@Override
	public List<Update> getNextUpdates(Integer poolingLimit, Integer poolingTimeout) {
		List<Update> updates = new ArrayList<>();

		try {
			Future<List<Update>> futureUpdates = client.executeMethod(
					GetUpdates.builder().offset(nextOffsetStrategy.getNextOffset()).timeout(poolingTimeout).limit(poolingLimit).build(),
					listTypeOf(Update.class));

			updates = futureUpdates.get();

			updates	.stream()
					.map(Update::getUpdateId)
					.max(comparingInt(Integer::intValue).reversed())
					.ifPresent(value -> nextOffsetStrategy.saveLastOffset(value));
		} catch (InterruptedException | ExecutionException e) {
			log.error("Can't get updates with exception {}", e);
		}

		return updates;
	}

	@Override
	public <T extends BotApiMethod> Future<Message> sendMessageAsync(@NotNull T message) {
		return client.executeMethod(message, simpleTypeOf(Message.class));
	}

	@Override
	public <T extends BotApiMethod> Optional<Message> sendMessageSync(@NotNull T message) {
		return executeSync(client.executeMethod(message, simpleTypeOf(Message.class)), message);
	}

	@Override
	public Optional<User> getMe() {
		GetMe method = GetMe.builder().build();
		return executeSync(client.executeMethod(method, simpleTypeOf(User.class)), method);
	}

	@Override
	public Optional<File> getFile(@NotNull String file_id) {
		GetFile method = GetFile.builder().fileId(file_id).build();
		return executeSync(client.executeMethod(method, simpleTypeOf(File.class)), method);
	}

	@Override
	public Optional<UserProfilePhotos> getUserProfilePhotos(@NotNull GetUserProfilePhotos getUserProfilePhotos) {
		Future<UserProfilePhotos> userProfilePhotosFuture = client.executeMethod(getUserProfilePhotos, simpleTypeOf(UserProfilePhotos.class));
		return executeSync(userProfilePhotosFuture, getUserProfilePhotos);
	}

	@Override
	public Future<Boolean> answerInlineQuery(@NotNull AnswerInlineQuery answerInlineQuery) {
		return client.executeMethod(answerInlineQuery, simpleTypeOf(Boolean.class));
	}

	@Override
	public Future<Boolean> answerCallbackQuery(@NotNull AnswerCallbackQuery answerCallbackQuery) {
		return client.executeMethod(answerCallbackQuery, simpleTypeOf(Boolean.class));
	}

	@Override
	public Optional<Chat> getChat(@NotNull String chatId) {
		GetChat method = GetChat.builder().chatId(chatId).build();
		return executeSync(client.executeMethod(method, simpleTypeOf(Chat.class)), method);
	}

	@Override
	public Optional<ArrayList<ChatMember>> getChatAdministrators(@NotNull String chatId) {
		GetChatAdministrators method = GetChatAdministrators.builder().chatId(chatId).build();
		Future<ArrayList<ChatMember>> chatFuture = client.executeMethod(method, listTypeOf(ChatMember.class));
		return executeSync(chatFuture, method);
	}

	@Override
	public Optional<Boolean> leaveChat(@NotNull String chatId) {
		LeaveChat method = LeaveChat.builder().chatId(chatId).build();
		Future<Boolean> leaveChatFuture = client.executeMethod(method, simpleTypeOf(Boolean.class));
		return executeSync(leaveChatFuture, method);
	}

	@Override
	public Optional<Boolean> unbanChatMember(@NotNull String chatId, @NotNull Integer userId) {
		UnbanChatMember method = UnbanChatMember.builder().chatId(chatId).userId(userId).build();
		Future<Boolean> unbanChatMemberFuture = client.executeMethod(method, simpleTypeOf(Boolean.class));
		return executeSync(unbanChatMemberFuture, method);
	}

	@Override
	public Optional<Boolean> kickChatMember(@NotNull String chatId, @NotNull Integer userId) {
		KickChatMember method = KickChatMember.builder().chatId(chatId).userId(userId).build();
		Future<Boolean> kickChatMemberFuture = client.executeMethod(method, simpleTypeOf(Boolean.class));
		return executeSync(kickChatMemberFuture, method);
	}

	@Override
	public Optional<Integer> getChatMemberCount(@NotNull String chatId) {
		GetChatMembersCount method = GetChatMembersCount.builder().chatId(chatId).build();
		Future<Integer> getChatMembersFuture = client.executeMethod(method, simpleTypeOf(Integer.class));
		return executeSync(getChatMembersFuture, method);
	}

	@Override
	public Future<Boolean> sendChatAction(@NotNull String chatId, ActionTypes action) {
		return client.executeMethod(SendChatAction	.builder()
													.chatId(chatId)
													.action(action)
													.build(),
				simpleTypeOf(Boolean.class));
	}

	private <T> Optional<T> executeSync(Future<T> futureResult, BotApiMethod method) {
		try {
			return of(futureResult.get());
		} catch (InterruptedException | ExecutionException e) {
			log.error("Error occured while executing method [{}], cause: ", method.getPath(), e);
		}

		return empty();
	}

}
