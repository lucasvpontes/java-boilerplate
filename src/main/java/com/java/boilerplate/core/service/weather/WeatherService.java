package com.java.boilerplate.core.service.weather;

import com.java.boilerplate.core.domain.weather.Weather;
import com.java.boilerplate.infrastructure.controller.dto.response.weather.WeatherResponse;
import com.java.boilerplate.infrastructure.rest.WeatherClient;
import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherService {
  private final WeatherClient client;

  public WeatherResponse getWeatherByCity(String city, String appId) {
    Weather response = client.getWeather(city, appId);

    double temperatureInKelvin = response.getMain().getTemperatureInKelvin();

    return WeatherResponse.builder()
            .temperatureInKelvin(format(temperatureInKelvin))
            .temperatureInFahrenheit(getTemperatureInFahrenheit(temperatureInKelvin))
            .temperatureInCelsius(getTemperatureInCelsius(temperatureInKelvin))
            .build();
  }

  private double getTemperatureInCelsius(double temperatureInKelvin) {
    return format(temperatureInKelvin - 273.15);
  }

  private double getTemperatureInFahrenheit(double temperatureInKelvin) {
    return format(1.8 * (temperatureInKelvin - 273.15) + 32);
  }

  private double format(double temperature) {
    return Double.parseDouble(
            String.format(
            Locale.US,
            "%.2f",
            temperature)
    );
  }
}
