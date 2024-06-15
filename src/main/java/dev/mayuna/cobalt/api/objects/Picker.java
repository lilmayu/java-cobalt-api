package dev.mayuna.cobalt.api.objects;

import lombok.Getter;

/**
 * Represents the picker item.<br>
 * Field <code>type</code> is used only if the <code>pickerType</code> (in {@link DownloadResult}) is <code>various</code>.<br>
 * Field <code>thumb</code> is used only if the <code>type</code> (in this class) is <code>video</code>.
 */
@SuppressWarnings("LombokGetterMayBeUsed")
@Getter
public final class Picker {

    private String type;
    private String url;
    private String thumb;

    /**
     * Direct link to a file or a link to cobalt's live render
     *
     * @return The URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * Item thumbnail that's displayed in the picker (only for <code>video</code> type)
     *
     * @return The thumbnail URL
     */
    public String getThumb() {
        return thumb;
    }
}
