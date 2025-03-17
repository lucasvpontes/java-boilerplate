package com.java.boilerplate.infrastructure.rest;

import com.java.boilerplate.core.domain.weather.Weather;
import com.java.boilerplate.infrastructure.util.ObjectMapperUtils;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.springframework.stereotype.Component;

@Component
public class WeatherClient {

    public Weather getWeather(String city, String appId) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s".formatted(city, appId)))
                    .GET()
                    .build();

            HttpClient client = HttpClient.newBuilder().build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return ObjectMapperUtils.jsonToObject(response.body(), Weather.class);
        } catch (URISyntaxException | IOException | InterruptedException e) {
            // TODO: Create a domain entity not found exception
            throw new RuntimeException(e);
        }
    }
}
