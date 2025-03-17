package com.java.boilerplate.core.domain.weather;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class Weather {
  @JsonProperty("main")
  private WeatherMain main;
}
