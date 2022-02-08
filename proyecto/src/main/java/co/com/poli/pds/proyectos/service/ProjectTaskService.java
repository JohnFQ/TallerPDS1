package co.com.poli.pds.proyectos.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import co.com.poli.pds.proyectos.entity.ProjectTask;
import co.com.poli.pds.proyectos.model.Response;

public interface ProjectTaskService {
	
	Response createTask(ProjectTask newTask);
	
	List<ProjectTask> viewAllTaskProject(Integer projectIdentifier);
	
	Double allHoursProject(String projectIdentifier);
	
	Double AllHoursxStatus(String projectIdentifier, String status);
	
	Response changeStatusTask(Long idTask, String projectIdentifier);
}
