package dev.mayuna.cobalt.api.objects;

/**
 * Represents a codec.<br>
 * Applies only to YouTube downloads.<br>
 * Default is {@link Codec#H264}.
 */
public final class Codec {

    public static final Codec H264 = new Codec("h264");
    public static final Codec AV1 = new Codec("av1");
    public static final Codec VP9 = new Codec("vp9");

    private String codec;

    /**
     * Used for deserialization.
     */
    public Codec() {
    }

    private Codec(String codec) {
        this.codec = codec;
    }

    /**
     * Creates {@link Codec} from a string.
     *
     * @param codec The codec.
     *
     * @return Created {@link Codec} instance.
     */
    public static Codec fromString(String codec) {
        switch (codec) {
            case "h264":
                return H264;
            case "av1":
                return AV1;
            case "vp9":
                return VP9;
            default:
                return new Codec(codec);
        }
    }

    /**
     * Returns the codec.
     *
     * @return The codec.
     */
    public String get() {
        return codec;
    }
}
