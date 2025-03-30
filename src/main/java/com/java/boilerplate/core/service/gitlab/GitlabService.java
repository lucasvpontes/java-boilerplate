package com.java.boilerplate.core.service.gitlab;

import com.java.boilerplate.core.domain.gitlab.GitLabProject;
import com.java.boilerplate.infrastructure.rest.GitLabInternalClient;
import com.java.boilerplate.infrastructure.rest.GitlabClient;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GitlabService {
  private final GitlabClient client;

  private final GitLabInternalClient internalClient;

  public List<GitLabProject> getAllProjects() {
    return client.getProjects();
  }

  public String[] getProjectsByNameSorted() {
    String[] projects = client.getProjects().stream()
            .map(GitLabProject::getName)
            .toArray(String[]::new);

    Arrays.sort(projects);

    return projects;
  }

  public Map<String, List<String>> getProjectsByNamespace() {
    List<GitLabProject> gitLabProjects = client.getProjects();

    Map<String, List<String>> projectsMap = new HashMap<>();

    gitLabProjects.forEach(gitLabProject -> {
      if (projectsMap.containsKey(gitLabProject.getNamespace().getNamespaceName())) {
        String key = gitLabProject.getNamespace().getNamespaceName();
        List<String> projects = projectsMap.get(key);
        projects.add(gitLabProject.getName());
        projectsMap.put(key, projects);
      } else {
        projectsMap.put(gitLabProject.getName(), List.of(gitLabProject.getName()));
      }
    });
    return projectsMap;
  }

  public Map<String, List<String>> getMapList() {
    return internalClient.getProjectsInternalClient();
  }
}
