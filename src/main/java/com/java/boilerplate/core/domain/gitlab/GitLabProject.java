package com.java.boilerplate.core.domain.gitlab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitLabProject {
  @JsonProperty("name")
  private String name;

  @JsonProperty("namespace")
  private GitLabNamespace namespace;

  @NoArgsConstructor
  @JsonIgnoreProperties(ignoreUnknown = true)
  @AllArgsConstructor
  @Getter
  @Builder
  public static class GitLabNamespace {
    @JsonProperty("name")
    private String namespaceName;
  }
}


