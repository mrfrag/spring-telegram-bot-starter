package ru.skuptsov.telegram.bot.platform.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ning.http.client.AsyncHttpClient;

import ru.skuptsov.telegram.bot.platform.client.TelegramBotHttpClient;
import ru.skuptsov.telegram.bot.platform.client.impl.TelegramBotHttpClientImpl;

/**
 * @author Sergey Kuptsov
 * @since 22/05/2016
 */
@Configuration
public class TelegramBotClientConfiguration {

    @Value("${telegram.client.token}")
    private String clientToken;

    @Value("${telegram.client.baseUrl:https://api.telegram.org}")
    private String baseUrl;

    @Bean
    public ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.setSerializationInclusion(Include.NON_NULL);
        
        return objectMapper;
    }

    public TelegramBotHttpClient createTelegramBotClient(AsyncHttpClient asyncHttpClient) {
        return new TelegramBotHttpClientImpl(
                getObjectMapper(),
                asyncHttpClient,
                clientToken,
                baseUrl);
    }
}
