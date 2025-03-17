package com.java.boilerplate.core.domain.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@Builder
public class WeatherMain {
  @JsonProperty("temp")
  private float temperatureInKelvin;
}
