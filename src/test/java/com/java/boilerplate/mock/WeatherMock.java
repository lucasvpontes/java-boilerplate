package com.java.boilerplate.mock;

import com.java.boilerplate.core.domain.weather.Weather;
import com.java.boilerplate.core.domain.weather.WeatherMain;
import lombok.experimental.UtilityClass;

@UtilityClass
public class WeatherMock {
  public Weather get() {
    return Weather.builder()
            .main(WeatherMain.builder()
                    .temperatureInKelvin(276)
                    .build())
            .build();
  }
}
