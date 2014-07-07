package com.hashedin.service;

import java.util.List;

import com.hashedin.model.Project;

public interface projectInterface {

	Project findProject(int projectId);

	Project createProject(Project Project);

	List<Project> getAllProject();

	
	
}
