package com.hashedin.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hashedin.model.Project;

@Repository("ProjectRepository")
public class ProjectRepositoryImpl implements ProjectRepository {

	@PersistenceContext
	private EntityManager em;

	public Project findProject(int Id) {
		// Returns the Project for given ProjectId.
		return em.find(Project.class, Id);
	}
	 @Transactional
	public Project createProject(Project Project) {
		// Saves the given Project object and returns the same.
		em.persist(Project);
		em.flush();
		return Project;
	}

	@Override
	/*
	 * public List<Project> getAllProject() { // TODO Auto-generated method stub
	 * return null; }
	 	 */
	public List<Project> getAllProject() { // Returns all the
		// Projects in our system.
		TypedQuery<Project> query = em.createNamedQuery("Project.findAll",Project.class);
		List<Project> results = query.getResultList();
		return results;
	};

}
