package com.java.boilerplate.infrastructure.controller;

import com.java.boilerplate.core.service.weather.WeatherService;
import com.java.boilerplate.infrastructure.controller.dto.response.weather.WeatherResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/weather", produces = MediaType.APPLICATION_JSON_VALUE)
public class WeatherController {

  public final WeatherService service;

  @GetMapping("/city/{city}")
  public ResponseEntity<WeatherResponse> getWeatherByCity(@PathVariable String city, @RequestParam String appId) {
    return ResponseEntity.ok().body(service.getWeatherByCity(city, appId));
  }
}
