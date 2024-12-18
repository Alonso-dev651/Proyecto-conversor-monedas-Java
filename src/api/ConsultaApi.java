package api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {

    Gson gson = new GsonBuilder()
            .create();

    public double convertirMoneda(String monedaInicial, String monedaDeseada, Double cantidad) {

        String direccion = "https://v6.exchangerate-api.com/v6/7d792f7109f76c23a411deaf/pair/" +
                monedaInicial + "/" + monedaDeseada + "/" + cantidad;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException  e) {
            throw new RuntimeException(e);
        }

        String json = response.body();
        Conversor conversorActual = gson.fromJson(json, Conversor.class);

        double tasaDeCambio = conversorActual.conversion_rate();

        return cantidad * tasaDeCambio;
    }
}
