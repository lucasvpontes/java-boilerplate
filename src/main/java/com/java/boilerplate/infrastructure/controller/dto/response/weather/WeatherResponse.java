package com.java.boilerplate.infrastructure.controller.dto.response.weather;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class WeatherResponse {
  private double temperatureInCelsius;
  private double temperatureInFahrenheit;
  private double temperatureInKelvin;
}
