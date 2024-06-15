package dev.mayuna.cobalt.api.gson;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import dev.mayuna.cobalt.api.objects.DownloadResult;
import dev.mayuna.cobalt.api.objects.Picker;
import dev.mayuna.cobalt.api.objects.PickerType;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Custom deserializer for {@link DownloadResult}
 */
public final class DownloadResultDeserializer implements JsonDeserializer<DownloadResult> {

    @Override
    public DownloadResult deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String status = null;
        String text = null;

        String url = null;
        PickerType pickerType = null;
        List<Picker> picker = null;
        String audio = null;

        final JsonObject jsonObject = json.getAsJsonObject();

        if (jsonObject.has("status")) {
            status = jsonObject.get("status").getAsString();
        }

        if (jsonObject.has("text")) {
            text = jsonObject.get("text").getAsString();
        }


        if (jsonObject.has("url")) {
            url = jsonObject.get("url").getAsString();
        }

        if (jsonObject.has("pickerType")) {
            pickerType = PickerType.fromString(jsonObject.get("pickerType").getAsString());
        }

        if (jsonObject.has("picker")) {
            picker = context.deserialize(jsonObject.get("picker"), new TypeToken<List<Picker>>(){}.getType());
        }

        if (jsonObject.has("audio")) {
            audio = jsonObject.get("audio").getAsString();
        }

        return new DownloadResult(status, text, url, pickerType, picker, audio);
    }
}
