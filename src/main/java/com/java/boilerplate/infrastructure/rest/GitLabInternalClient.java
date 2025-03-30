package com.java.boilerplate.infrastructure.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class GitLabInternalClient {
  public Map<String, List<String>> getProjectsInternalClient() {
    try {
      HttpRequest request = HttpRequest.newBuilder().uri(new URI("http://localhost:8080/gitlab/projects/namespace"))
              .GET()
              .build();

      HttpClient client = HttpClient.newBuilder().build();

      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

      ObjectMapper mapper = new ObjectMapper();

      Map<String, List<String>> mapList = mapper.readValue(response.body(),
              mapper.getTypeFactory().constructMapType(HashMap.class, String.class, List.class));

      return mapList;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
