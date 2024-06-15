package dev.mayuna.cobalt.api;

import com.google.gson.Gson;
import dev.mayuna.simpleapi.GsonApiResponse;
import lombok.Getter;

/**
 * Cobalt API response<br>
 * If the response is an error, {@link #isError()} will return true and {@link #getText()} will return the error message.
 */
@Getter
public abstract class CobaltApiResponse extends GsonApiResponse<CobaltApi> {

    protected String status;
    protected String text;

    /**
     * Checks if the response is an error
     *
     * @return True if the response is an error
     */
    public boolean isError() {
        return status != null && (status.equals("error") || status.equals("rate-limit"));
    }

    /**
     * Checks if the response is rate limited
     *
     * @return True if the response is rate limited
     */
    public boolean isRateLimited() {
        return status != null && status.equals("rate-limit");
    }

    /**
     * Gets the response's text
     */
    @SuppressWarnings("LombokGetterMayBeUsed")
    public String getText() {
        return text;
    }

    @Override
    public Gson getGson() {
        return getWrappedApi().getGson();
    }
}
