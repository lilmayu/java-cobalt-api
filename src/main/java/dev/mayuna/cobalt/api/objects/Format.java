package dev.mayuna.cobalt.api.objects;

/**
 * Represents the format.<br>
 * Default is {@link Format#MP3}.
 */
public final class Format {

    public static final Format BEST = new Format("best");
    public static final Format MP3 = new Format("mp3");
    public static final Format OGG = new Format("ogg");
    public static final Format WAV = new Format("wav");
    public static final Format OPUS = new Format("opus");

    private String format;

    /**
     * Used for deserialization.
     */
    public Format() {
    }

    private Format(String format) {
        this.format = format;
    }

    /**
     * Creates {@link Format} from a string.
     *
     * @param format The format.
     *
     * @return Created {@link Format} instance.
     */
    public static Format fromString(String format) {
        switch (format) {
            case "best":
                return BEST;
            case "mp3":
                return MP3;
            case "ogg":
                return OGG;
            case "wav":
                return WAV;
            case "opus":
                return OPUS;
            default:
                return new Format(format);
        }
    }

    /**
     * Returns the format.
     *
     * @return The format.
     */
    public String get() {
        return format;
    }
}
