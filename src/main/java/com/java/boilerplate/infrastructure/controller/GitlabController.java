package com.java.boilerplate.infrastructure.controller;

import com.java.boilerplate.core.domain.gitlab.GitLabProject;
import com.java.boilerplate.core.service.gitlab.GitlabService;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/gitlab", produces = MediaType.APPLICATION_JSON_VALUE)
public class GitlabController {

  private final GitlabService service;

  @GetMapping("/projects")
  public ResponseEntity<List<GitLabProject>> getAllProjects() {
    List<GitLabProject> projects = service.getAllProjects();

    return ResponseEntity.ok(projects);
  }

  @GetMapping("/projects/name")
  public ResponseEntity<String[]> getProjectsNameSorted() {
    String[] projectsNameSorted = service.getProjectsByNameSorted();
    return ResponseEntity.ok(projectsNameSorted);
  }

  @GetMapping("/projects/namespace")
  public ResponseEntity<Map<String, List<String>>> getProjectsNameByNameSpace() {
    Map<String, List<String>> projectsNameByNamespace = service.getProjectsByNamespace();
    return ResponseEntity.ok(projectsNameByNamespace);
  }

  @GetMapping("/projects/recursive")
  public ResponseEntity<Map<String, List<String>>> getProjectsRecursive() {
    Map<String, List<String>> projectsNameByNamespace = service.getProjectsByNamespace();
    return ResponseEntity.ok(projectsNameByNamespace);
  }

  @GetMapping("/internal/recursive")
  public ResponseEntity<Map<String, List<String>>> getInternalProjectsRecursive() {
    Map<String, List<String>> internalProjectsNameByNamespace = service.getMapList();
    return ResponseEntity.ok(internalProjectsNameByNamespace);
  }
}
