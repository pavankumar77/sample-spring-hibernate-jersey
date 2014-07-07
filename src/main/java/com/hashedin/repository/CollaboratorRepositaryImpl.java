package com.hashedin.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hashedin.model.Collaborators;

import com.hashedin.model.Task;

public class CollaboratorRepositaryImpl implements CollaboratorRepositary{
	
	@PersistenceContext
	private EntityManager em;

	
	
	public Collaborators createCollaborator(Collaborators collaborator) {
		em.persist(collaborator);
		em.flush();
		return collaborator;
	}



	@Override
	public Task getAllTasks(int collaboratorId) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void assignTask() {
		// TODO Auto-generated method stub
		
	}

}
