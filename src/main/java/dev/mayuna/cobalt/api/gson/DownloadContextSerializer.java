package dev.mayuna.cobalt.api.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import dev.mayuna.cobalt.api.objects.DownloadContext;

import java.lang.reflect.Type;

/**
 * Custom serializer for {@link DownloadContext}.
 */
public final class DownloadContextSerializer implements JsonSerializer<DownloadContext> {

    @Override
    public JsonElement serialize(DownloadContext src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("url", src.getUrl());

        if (src.getCodec() != null) {
            jsonObject.addProperty("codec", src.getCodec().get());
        }

        if (src.getQuality() != null) {
            jsonObject.addProperty("quality", src.getQuality().get());
        }

        if (src.getFormat() != null) {
            jsonObject.addProperty("format", src.getFormat().get());
        }

        if (src.getFileNamePattern() != null) {
            jsonObject.addProperty("fileNamePattern", src.getFileNamePattern().get());
        }

        jsonObject.addProperty("isAudioOnly", src.isAudioOnly());
        jsonObject.addProperty("isTTFullAudio", src.isTTFullAudio());
        jsonObject.addProperty("isAudioMuted", src.isAudioMuted());
        jsonObject.addProperty("dubLang", src.isDubLang());
        jsonObject.addProperty("disableMetadata", src.isDisableMetadata());
        jsonObject.addProperty("twitterGif", src.isTwitterGif());
        jsonObject.addProperty("tiktokH265", src.isTiktokH265());

        return jsonObject;
    }
}
