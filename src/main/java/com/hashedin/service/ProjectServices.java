package com.hashedin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hashedin.model.Project;
import com.hashedin.repository.ProjectRepository;

@Service("ProjectServices")
public class ProjectServices implements projectInterface {

	@Autowired
	private ProjectRepository ProjectRepository;

	public Project findProject(int Id) {
		// Returns the Project for given ProjectId.
		return ProjectRepository.findProject(Id);
	}

	@Override
	public Project createProject(Project Project) {
		// Saves the given Project object and returns the same.
		ProjectRepository.createProject(Project);
		return Project;
	}

	@Override
	public List<Project> getAllProject() {
		// Returns all the Projects in our system.
		return ProjectRepository.getAllProject();
	}

}
