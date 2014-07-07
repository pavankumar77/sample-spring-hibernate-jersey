package com.hashedin.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "Projects")
@NamedQueries({ @NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p") })
public class Project {

	@Id
	@GeneratedValue
	private int Id;

	@OneToMany(mappedBy = "project")
	private List<Task> task;

	private String description;

	// private List <Collaborators> collaborator;
	// public List<Collaborators> getCollaborator() {
	// return collaborator;
	// }
	// public void setCollaborator(List<Collaborators> collaborator) {
	// this.collaborator = collaborator;
	// }
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
