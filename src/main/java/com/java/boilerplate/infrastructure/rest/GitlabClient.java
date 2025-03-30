package com.java.boilerplate.infrastructure.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.boilerplate.core.domain.gitlab.GitLabProject;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class GitlabClient {
  public List<GitLabProject> getProjects() {
    try {

      HttpRequest request = HttpRequest.newBuilder()
              .uri(new URI("https://gitlab.com/api/v4/projects"))
              .GET()
              .build();

      HttpClient client = HttpClient.newBuilder().build();

      ObjectMapper objectMapper = new ObjectMapper();

      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

      List<GitLabProject> projects = objectMapper.readValue(response.body(),
              objectMapper.getTypeFactory().constructCollectionType(List.class, GitLabProject.class));

      // objectMapper.readValue(response.body(), objectMapper.getTypeFactory().constructMapType(HashMap.class, String.class, Object.class));

      return projects;
    } catch (URISyntaxException | IOException | InterruptedException e) {
      // TODO: Create a domain entity not found exception
      throw new RuntimeException(e);
    }
  }
}
