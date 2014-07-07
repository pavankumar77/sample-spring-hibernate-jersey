package com.hashedin.repository;

import com.hashedin.model.Task;


public interface CollaboratorRepositary {

	
	Task getAllTasks(int collaboratorId);
	void  assignTask() ;
	
}
