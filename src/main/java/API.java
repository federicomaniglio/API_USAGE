import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API {
    private HttpClient client;
    private final String baseURL = "https://pokeapi.co/api/v2/";

    // Potrebbe essere singleton
    public API() {
        this.client = HttpClient.newHttpClient();
    }

    public Pokemon getPokemonByName(String name) throws IOException, InterruptedException {
        HttpRequest httpRequest =
                HttpRequest.newBuilder()
                        .GET()
                        .uri(URI.create(baseURL + "pokemon/" + name))
                        .build();

        HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new IOException("Error: "+ response.statusCode() + "\nFailed to retrieve pokemon data");
        }

        Gson gson = new Gson();

        return gson.fromJson(response.body(), Pokemon.class);
    }
}
