package dev.mayuna.cobalt.api.objects;

import dev.mayuna.cobalt.api.CobaltApiResponse;
import lombok.Getter;

import java.util.List;

/**
 * Represents the download result. <a href="https://github.com/imputnet/cobalt/blob/current/docs/api.md#post-apijson">Documentation</a>
 */
@SuppressWarnings("LombokGetterMayBeUsed")
@Getter
public final class DownloadResult extends CobaltApiResponse {

    private String url;
    private PickerType pickerType;
    private List<Picker> picker;
    private String audio;

    /**
     * Used for deserialization.
     */
    public DownloadResult() {
    }

    /**
     * Creates a new {@link DownloadResult} instance.
     *
     * @param status     The status
     * @param text       The request's text
     * @param url        The URL
     * @param pickerType The picker type
     * @param picker     List of pickers
     * @param audio      The audio URL
     */
    public DownloadResult(String status, String text, String url, PickerType pickerType, List<Picker> picker, String audio) {
        this.status = status;
        this.text = text;
        this.url = url;
        this.pickerType = pickerType;
        this.picker = picker;
        this.audio = audio;
    }

    /**
     * Direct link to a file or a link to cobalt's live render
     *
     * @return The URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * Direct link to a file or a link to cobalt's live render
     *
     * @return The URL
     */
    public String getAudio() {
        return audio;
    }

    @Override
    public String toString() {
        return "DownloadResult{" +
                "url='" + url + '\'' +
                ", pickerType=" + pickerType +
                ", picker=" + picker +
                ", audio='" + audio + '\'' +
                ", status='" + status + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
