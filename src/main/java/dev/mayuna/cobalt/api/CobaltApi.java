package dev.mayuna.cobalt.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.mayuna.cobalt.api.gson.DownloadContextSerializer;
import dev.mayuna.cobalt.api.gson.DownloadResultDeserializer;
import dev.mayuna.cobalt.api.objects.DownloadContext;
import dev.mayuna.cobalt.api.objects.DownloadResult;
import dev.mayuna.cobalt.api.objects.ServerInfo;
import dev.mayuna.simpleapi.ApiRequest;
import dev.mayuna.simpleapi.RequestHeader;
import dev.mayuna.simpleapi.RequestMethod;
import dev.mayuna.simpleapi.WrappedApi;
import lombok.Getter;
import lombok.NonNull;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;

/**
 * Wrapper for the <a href="https://github.com/imputnet/cobalt/blob/current/docs/api.md">Cobalt API</a>
 */
@Getter
public class CobaltApi implements WrappedApi {

    /**
     * TODO: Rate limits
     *  - ratelimit-policy; 20;w=60 (20 requests per window of seconds)
     *  - ratelimit-limit; max requests per window
     *  - ratelimit-remaining; remaining requests in the window
     *  - ratelimit-reset; seconds until the window resets
     */

    private final HttpClient httpClient;
    private final Gson gson;
    private final String apiUrl;

    /**
     * Creates a new {@link CobaltApi} instance.
     *
     * @param httpClient  The {@link HttpClient} to use.
     * @param gsonBuilder The {@link GsonBuilder} to use.
     * @param apiUrl      The API URL, without a trailing slash.
     */
    private CobaltApi(@NonNull HttpClient httpClient, @NonNull GsonBuilder gsonBuilder, @NonNull String apiUrl) {
        this.httpClient = httpClient;

        this.gson = gsonBuilder.registerTypeAdapter(DownloadResult.class, new DownloadResultDeserializer())
                               .registerTypeAdapter(DownloadContext.class, new DownloadContextSerializer())
                               .create();

        // Ensure the API URL ends with a slash
        if (apiUrl.endsWith("/")) {
            apiUrl = apiUrl.substring(0, apiUrl.length() - 1);
        }

        this.apiUrl = apiUrl;
    }

    /**
     * Creates a new {@link CobaltApi} instance.
     *
     * @param httpClient The {@link HttpClient} to use.
     * @param apiUrl     The API URL, ending with a slash.
     */
    public CobaltApi(@NonNull HttpClient httpClient, @NonNull String apiUrl) {
        this(httpClient, new GsonBuilder(), apiUrl);
    }

    /**
     * Creates a new {@link CobaltApi} instance.
     *
     * @param gsonBuilder The {@link GsonBuilder} to use.
     * @param apiUrl      The API URL, ending with a slash.
     */
    public CobaltApi(@NonNull GsonBuilder gsonBuilder, @NonNull String apiUrl) {
        this(HttpClient.newHttpClient(), gsonBuilder, apiUrl);
    }

    /**
     * Creates a new {@link CobaltApi} instance.
     *
     * @param apiUrl The API URL, ending with a slash.
     */
    public CobaltApi(@NonNull String apiUrl) {
        this(HttpClient.newHttpClient(), new GsonBuilder(), apiUrl);
    }

    @Override
    public String getDefaultUrl() {
        return apiUrl;
    }

    @Override
    public RequestHeader[] getDefaultRequestHeaders() {
        return new RequestHeader[] {
                RequestHeader.of("User-Agent", "Java-Cobalt-Api (dev.mayuna, 1.0.0)"),
                RequestHeader.of("Accept", "application/json"),
                RequestHeader.of("Content-Type", "application/json")
        };
    }

    @Override
    public HttpClient createHttpClientInstance() {
        return this.httpClient;
    }

    /**
     * Creates a request to fetch the {@link ServerInfo}.
     *
     * @return The API request.
     */
    public ApiRequest<ServerInfo> getServerInfo() {
        return ApiRequest.builder(this, ServerInfo.class)
                         .withEndpoint("/api/serverInfo")
                         .withRequestMethod(RequestMethod.GET)
                         .build();
    }

    /**
     * Creates a request to download a video.
     *
     * @param downloadContext The {@link DownloadContext} containing information about the desired download.
     *
     * @return The API request.
     */
    public ApiRequest<DownloadResult> getDownload(@NonNull DownloadContext downloadContext) {
        var apiRequestBuilder = ApiRequest.builder(this, DownloadResult.class)
                                          .withEndpoint("/api/json")
                                          .withRequestMethod(RequestMethod.POST)
                                          .withBodyPublisher(HttpRequest.BodyPublishers.ofString(gson.toJson(downloadContext)));

        if (downloadContext.isDubLang()) {
            apiRequestBuilder.withRequestHeader(RequestHeader.of("Accept-Language", downloadContext.getLanguage()));
        }

        return apiRequestBuilder.build();
    }
}
