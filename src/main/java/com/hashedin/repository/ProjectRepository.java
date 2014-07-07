package com.hashedin.repository;

import java.util.List;

import com.hashedin.model.Project;

public interface ProjectRepository {

	Project findProject(int projectId);

	Project createProject(Project Project);

	List<Project> getAllProject();

}
