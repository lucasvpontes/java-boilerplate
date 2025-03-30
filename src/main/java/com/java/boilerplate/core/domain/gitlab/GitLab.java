package com.java.boilerplate.core.domain.gitlab;


import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class GitLab {

  private List<GitLabProject> projects;
}
