package dev.mayuna.cobalt.api.objects;

/**
 * Represents the file name pattern.<br>
 * Default is {@link FileNamePattern#CLASSIC}.
 */
public final class FileNamePattern {

    public static final FileNamePattern CLASSIC = new FileNamePattern("classic");
    public static final FileNamePattern PRETTY = new FileNamePattern("pretty");
    public static final FileNamePattern BASIC = new FileNamePattern("basic");
    public static final FileNamePattern NERDY = new FileNamePattern("nerdy");

    private String pattern;

    /**
     * Used for deserialization.
     */
    public FileNamePattern() {
    }

    private FileNamePattern(String pattern) {
        this.pattern = pattern;
    }

    /**
     * Creates {@link FileNamePattern} from a string.
     *
     * @param pattern The pattern.
     *
     * @return Created {@link FileNamePattern} instance.
     */
    public static FileNamePattern fromString(String pattern) {
        switch (pattern) {
            case "classic":
                return CLASSIC;
            case "pretty":
                return PRETTY;
            case "basic":
                return BASIC;
            case "nerdy":
                return NERDY;
            default:
                return new FileNamePattern(pattern);
        }
    }

    /**
     * Returns the pattern.
     *
     * @return The pattern.
     */
    public String get() {
        return pattern;
    }
}