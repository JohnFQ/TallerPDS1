package co.com.poli.pds.proyectos.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import co.com.poli.pds.proyectos.entity.ProjectTask;

public interface ProjectTaskService {
	
	ResponseEntity<ProjectTask> createTask(ProjectTask newTask);
	
	List<ProjectTask> viewAllTaskProject(Integer projectIdentifier);
	
	Double allHoursProject(String projectIdentifier);
	
	Double AllHoursxStatus(String projectIdentifier, String status);
	
	ResponseEntity<ProjectTask> changeStatusTask(Long idTask, String projectIdentifier);
}
