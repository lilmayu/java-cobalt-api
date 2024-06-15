package dev.mayuna.cobalt.api.objects;

/**
 * Represents the quality.<br>
 * Default is {@link Quality#_720P}.
 */
public final class Quality {

    public static final Quality _144P = new Quality("144");
    public static final Quality _240P = new Quality("240");
    public static final Quality _360P = new Quality("360");
    public static final Quality _480P = new Quality("480");
    public static final Quality _720P = new Quality("720");
    public static final Quality _1080P = new Quality("1080");
    public static final Quality _1440P = new Quality("1440");
    public static final Quality _2160P = new Quality("2160");
    public static final Quality MAX = new Quality("max");

    private String quality;

    /**
     * Used for deserialization.
     */
    public Quality() {
    }

    private Quality(String quality) {
        this.quality = quality;
    }

    /**
     * Creates {@link Quality} from a string.
     *
     * @param quality The quality.
     *
     * @return Created {@link Quality} instance.
     */
    public static Quality fromString(String quality) {
        switch (quality) {
            case "144":
                return _144P;
            case "240":
                return _240P;
            case "360":
                return _360P;
            case "480":
                return _480P;
            case "720":
                return _720P;
            case "1080":
                return _1080P;
            case "1440":
                return _1440P;
            case "2160":
                return _2160P;
            case "max":
                return MAX;
            default:
                return new Quality(quality);
        }
    }

    /**
     * Returns the quality.
     *
     * @return The quality.
     */
    public String get() {
        return quality;
    }
}
