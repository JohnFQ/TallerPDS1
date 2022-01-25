package co.com.poli.pds.proyectos.service;

import java.util.List;

import co.com.poli.pds.proyectos.entity.ProjectTask;

public interface ProjectTaskService {
	
	ProjectTask createTask(ProjectTask newTask);
	
	List<ProjectTask> viewAllTaskProject(int projectIdentifier);
	
	int allHoursProject(int projectIdentifier);
	
	int AllHoursxStatus(int projectIdentifier, String status);
	
	boolean changeStatusTask(int idTask, int projectIdentifier);
}
