package services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Set;

public class HttpService {
    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    private HttpService() {}
    private static HttpService instance = new HttpService();

    public static HttpService getInstance() {
        return instance;
    }

    public HttpResponse<String> get(String uri, Map<String, String> headers) throws IOException, InterruptedException {

        Set<String> keys = headers.keySet();


        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(uri))
//                .headers()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return response;
    }

    public HttpResponse<String> post(String uri, String bodyJson, Map<String, String> headers) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(bodyJson))
                .uri(URI.create(uri))
                .headers("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return response;
    }

    public HttpResponse<String> put(String uri, String bodyJson, Map<String, String> headers) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .PUT(HttpRequest.BodyPublishers.ofString(bodyJson))
                .uri(URI.create(uri))
                .headers("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return response;
    }

    public HttpResponse<String> delete(String uri, Map<String, String> headers) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .DELETE()
                .uri(URI.create(uri))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return response;
    }

}
