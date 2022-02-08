package co.com.poli.pds.proyectos.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import co.com.poli.pds.proyectos.entity.ProjectTask;
import co.com.poli.pds.proyectos.model.Response;

public interface ProjectTaskService {
	
	void createTask(ProjectTask newTask);
	
	List<ProjectTask> viewAllTaskProject(String projectIdentifier);
	
	Response allHoursProject(String projectIdentifier);
	
	Response AllHoursxStatus(String projectIdentifier, String status);
	
	Response changeStatusTask(Long idTask, String projectIdentifier);
	
	List<ProjectTask> findAll(); 
}
