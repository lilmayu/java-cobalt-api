package dev.mayuna.cobalt.api.objects;

import lombok.Getter;
import lombok.NonNull;

/**
 * Represents the download context, containing information about the desired download.
 */
@Getter
public final class DownloadContext {

    private final String url;
    private final Codec codec;
    private final Quality quality;
    private final Format format;
    private final FileNamePattern fileNamePattern;
    private final boolean isAudioOnly;
    private final boolean isTTFullAudio;
    private final boolean isAudioMuted;
    private final boolean dubLang;
    private final String language;
    private final boolean disableMetadata;
    private final boolean twitterGif;
    private final boolean tiktokH265;

    /**
     * Creates a new {@link DownloadContext} instance.
     *
     * @param url             The URL
     * @param codec           The {@link Codec}
     * @param quality         The {@link Quality}
     * @param format          The {@link Format}
     * @param fileNamePattern The {@link FileNamePattern}
     * @param isAudioOnly     Whether the download is audio only
     * @param isTTFullAudio   Whether the download is original audio (TikTok)
     * @param isAudioMuted    Whether the audio is muted (e.g., only video)
     * @param dubLang         Whether should be Accept-Language header used for audio tracks (YouTube)
     * @param disableMetadata Whether the metadata is disabled
     * @param twitterGif      Whether the gifs are converted to .gif (Twitter)
     * @param tiktokH265      Whether the 1080p H.265 codec is used (TikTok)
     */
    public DownloadContext(@NonNull String url, @NonNull Codec codec, @NonNull Quality quality, @NonNull Format format, @NonNull FileNamePattern fileNamePattern, boolean isAudioOnly, boolean isTTFullAudio, boolean isAudioMuted, boolean dubLang, @NonNull String language, boolean disableMetadata, boolean twitterGif, boolean tiktokH265) {
        this.url = url;
        this.codec = codec;
        this.quality = quality;
        this.format = format;
        this.fileNamePattern = fileNamePattern;
        this.isAudioOnly = isAudioOnly;
        this.isTTFullAudio = isTTFullAudio;
        this.isAudioMuted = isAudioMuted;
        this.dubLang = dubLang;
        this.language = language;
        this.disableMetadata = disableMetadata;
        this.twitterGif = twitterGif;
        this.tiktokH265 = tiktokH265;
    }

    /**
     * Creates a new {@link Builder} instance.
     *
     * @param url The URL
     *
     * @return Created {@link Builder} instance.
     */
    public static Builder builder(@NonNull String url) {
        return new Builder(url);
    }

    /**
     * Builder for {@link DownloadContext}.
     */
    public static class Builder {

        private final String url;
        private Codec codec = Codec.H264;
        private Quality quality = Quality._720P;
        private Format format = Format.MP3;
        private FileNamePattern fileNamePattern = FileNamePattern.CLASSIC;
        private boolean isAudioOnly = false;
        private boolean isTTFullAudio = false;
        private boolean isAudioMuted = false;
        private boolean dubLang = false;
        private String language = "en";
        private boolean disableMetadata = false;
        private boolean twitterGif = false;
        private boolean tiktokH265 = false;

        /**
         * Creates a new {@link Builder} instance.
         *
         * @param url The URL
         */
        protected Builder(@NonNull String url) {
            this.url = url;
        }

        /**
         * Builds the {@link DownloadContext}.
         *
         * @return Created {@link DownloadContext} instance.
         */
        public DownloadContext build() {
            return new DownloadContext(url, codec, quality, format, fileNamePattern, isAudioOnly, isTTFullAudio, isAudioMuted, dubLang, language, disableMetadata, twitterGif, tiktokH265);
        }

        /**
         * Sets the codec.
         *
         * @param codec The {@link Codec}
         *
         * @return This {@link Builder} instance.
         */
        public Builder codec(@NonNull Codec codec) {
            this.codec = codec;
            return this;
        }

        /**
         * Sets the quality.
         *
         * @param quality The {@link Quality}
         *
         * @return This {@link Builder} instance.
         */
        public Builder quality(@NonNull Quality quality) {
            this.quality = quality;
            return this;
        }

        /**
         * Sets the format.
         *
         * @param format The {@link Format}
         *
         * @return This {@link Builder} instance.
         */
        public Builder format(@NonNull Format format) {
            this.format = format;
            return this;
        }

        /**
         * Sets the file name pattern.
         *
         * @param fileNamePattern The {@link FileNamePattern}
         *
         * @return This {@link Builder} instance.
         */
        public Builder fileNamePattern(@NonNull FileNamePattern fileNamePattern) {
            this.fileNamePattern = fileNamePattern;
            return this;
        }

        /**
         * Sets whether the download should be audio only.
         *
         * @param isAudioOnly Whether the download should be audio only.
         *
         * @return This {@link Builder} instance.
         */
        public Builder isAudioOnly(boolean isAudioOnly) {
            this.isAudioOnly = isAudioOnly;
            return this;
        }

        /**
         * Sets whether the download should be original audio (TikTok).
         *
         * @param isTTFullAudio Whether the download should be original audio (TikTok)
         *
         * @return This {@link Builder} instance.
         */
        public Builder isTTFullAudio(boolean isTTFullAudio) {
            this.isTTFullAudio = isTTFullAudio;
            return this;
        }

        /**
         * Sets whether the audio is muted (e.g., only video).
         *
         * @param isAudioMuted Whether the audio is muted (e.g., only video)
         *
         * @return This {@link Builder} instance.
         */
        public Builder isAudioMuted(boolean isAudioMuted) {
            this.isAudioMuted = isAudioMuted;
            return this;
        }

        /**
         * Disables the Accept-Language header for audio tracks (YouTube).
         *
         * @return This {@link Builder} instance.
         */
        public Builder disableDubLang() {
            this.dubLang = false;
            return this;
        }

        /**
         * Enables the Accept-Language header for audio tracks (YouTube) with the specified language.
         *
         * @param language Sets the language used in the Accept-Language header (<a
         *                 href="https://developers.google.com/youtube/v3/docs/i18nLanguages">i18n languages on YouTube documentation</a>, e.g.,
         *                 <code>en</code>)
         *
         * @return This {@link Builder} instance.
         */
        public Builder enableDubLang(String language) {
            this.dubLang = true;
            this.language = language;
            return this;
        }

        /**
         * Sets whether the metadata should be disabled.
         *
         * @param disableMetadata Whether the metadata should be disabled
         *
         * @return This {@link Builder} instance.
         */
        public Builder disableMetadata(boolean disableMetadata) {
            this.disableMetadata = disableMetadata;
            return this;
        }

        /**
         * Sets whether the gifs should be converted to .gif (Twitter).
         *
         * @param twitterGif Whether the gifs should be converted to .gif (Twitter)
         *
         * @return This {@link Builder} instance.
         */
        public Builder twitterGif(boolean twitterGif) {
            this.twitterGif = twitterGif;
            return this;
        }

        /**
         * Sets whether the 1080p H.265 codec should be used (TikTok).
         *
         * @param tiktokH265 Whether the 1080p H.265 codec should be used (TikTok)
         *
         * @return This {@link Builder} instance.
         */
        public Builder tiktokH265(boolean tiktokH265) {
            this.tiktokH265 = tiktokH265;
            return this;
        }
    }
}
