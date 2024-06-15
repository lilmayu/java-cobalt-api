package dev.mayuna.cobalt.api.objects;

import dev.mayuna.cobalt.api.CobaltApiResponse;
import lombok.Getter;

/**
 * Represents the server information. <a href="https://github.com/imputnet/cobalt/blob/current/docs/api.md#get-apiserverinfo">Documentation</a>
 */
@Getter
public final class ServerInfo extends CobaltApiResponse {

    private String version;
    private String commit;
    private String branch;
    private String name;
    private String url;
    private int cors;
    private String startTime;

    @Override
    public String toString() {
        return "ServerInfo{" +
                "version='" + version + '\'' +
                ", commit='" + commit + '\'' +
                ", branch='" + branch + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", cors=" + cors +
                ", startTime='" + startTime + '\'' +
                '}';
    }
}
