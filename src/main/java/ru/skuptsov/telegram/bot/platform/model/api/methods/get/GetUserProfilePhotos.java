package ru.skuptsov.telegram.bot.platform.model.api.methods.get;

import javax.validation.ValidationException;

import com.fasterxml.jackson.annotation.JsonProperty;

import ru.skuptsov.telegram.bot.platform.model.api.methods.BotApiMethod;

public class GetUserProfilePhotos  extends BotApiMethod {

    public static final String USERID_FIELD = "user_id";
    public static final String OFFSET_FIELD = "offset";
    public static final String LIMIT_FIELD = "limit";
    
    /**
     * Unique identifier of the target user
     */
    @JsonProperty(USERID_FIELD)
    private Integer userId;
    
    /**
     * Sequential number of the first photo to be returned. By default, all photos are returned.
     */
    private Integer offset;
    
    /**
     * Optional. Limits the number of photos to be retrieved. Values between 1—100 are accepted. Defaults to 100.
     */
    private Integer limit;

    public Integer getUserId() {
        return userId;
    }

    public GetUserProfilePhotos setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Override
    public void validate() {
        if (userId == null) {
            throw new ValidationException("UserId parameter can't be empty");
        }
        if (offset == null) {
            throw new ValidationException("Offset parameter can't be empty");
        }
    }

    @Override
    public String toString() {
        return "GetUserProfilePhotos{" +
                "userId=" + userId +
                ", offset=" + offset +
                ", limit=" + limit +
                '}';
    }
}
