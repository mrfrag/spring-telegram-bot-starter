package ru.skuptsov.telegram.bot.platform.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;

import javax.validation.constraints.NotNull;

import ru.skuptsov.telegram.bot.platform.model.api.methods.BotApiMethod;
import ru.skuptsov.telegram.bot.platform.model.api.methods.get.GetUserProfilePhotos;
import ru.skuptsov.telegram.bot.platform.model.api.methods.query.AnswerCallbackQuery;
import ru.skuptsov.telegram.bot.platform.model.api.methods.query.AnswerInlineQuery;
import ru.skuptsov.telegram.bot.platform.model.api.methods.send.SendChatAction.ActionType;
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
public interface TelegramBotApi {

	List<Update> getNextUpdates(Integer poolingLimit, Integer poolingTimeout);

	<R extends BotApiMethod> Future<Message> sendMessageAsync(@NotNull R command);

	<T extends BotApiMethod> Optional<Message> sendMessageSync(@NotNull T message);

	Optional<User> getMe();

	Optional<File> getFile(@NotNull String file_id);

	Optional<UserProfilePhotos> getUserProfilePhotos(@NotNull GetUserProfilePhotos getUserProfilePhotos);

	Future<Boolean> answerInlineQuery(@NotNull AnswerInlineQuery answerInlineQuery);

	Future<Boolean> answerCallbackQuery(@NotNull AnswerCallbackQuery answerCallbackQuery);

	Optional<Chat> getChat(@NotNull String chatId);

	Optional<ArrayList<ChatMember>> getChatAdministrators(@NotNull String chatId);

	Optional<Boolean> leaveChat(@NotNull String chatId);

	Optional<Boolean> unbanChatMember(@NotNull String chatId, @NotNull Integer userId);

	Optional<Boolean> kickChatMember(@NotNull String chatId, @NotNull Integer userId);

	Optional<Integer> getChatMemberCount(@NotNull String chatId);

	Future<Boolean> sendChatAction(@NotNull String chatId, ActionType action);
}
