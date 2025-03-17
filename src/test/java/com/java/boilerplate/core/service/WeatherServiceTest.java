package com.java.boilerplate.core.service;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.java.boilerplate.core.domain.weather.Weather;
import com.java.boilerplate.core.service.weather.WeatherService;
import com.java.boilerplate.infrastructure.controller.dto.response.weather.WeatherResponse;
import com.java.boilerplate.infrastructure.rest.WeatherClient;
import com.java.boilerplate.mock.WeatherMock;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class WeatherServiceTest {
  @Mock WeatherClient client;

  @InjectMocks WeatherService service;

  @Test
  void should_getWeather_when_cityAndApiKeyHasValidValues() {
    when(client.getWeather(anyString(), anyString())).thenReturn(WeatherMock.get());

    WeatherResponse response = service.getWeatherByCity("Berlin", UUID.randomUUID().toString());

    Assertions.assertEquals(2.85, response.getTemperatureInCelsius());
    Assertions.assertEquals(37.13, response.getTemperatureInFahrenheit());
    Assertions.assertEquals(276.0, response.getTemperatureInKelvin());
  }
}
