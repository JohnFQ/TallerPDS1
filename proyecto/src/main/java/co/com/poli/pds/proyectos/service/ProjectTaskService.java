package co.com.poli.pds.proyectos.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import co.com.poli.pds.proyectos.entity.ProjectTask;

public interface ProjectTaskService {
	
<<<<<<< HEAD
	ResponseEntity<ProjectTask> createTask(ProjectTask newTask);
=======
	void createTask(ProjectTask newTask);
>>>>>>> 2a2ec10 (Finalizacion del service de projectTask, ajustar su create y ajuste del test al repository)
	
	List<ProjectTask> viewAllTaskProject(String projectIdentifier);
	
	Response allHoursProject(String projectIdentifier);
	
	Response AllHoursxStatus(String projectIdentifier, String status);
	
<<<<<<< HEAD
	ResponseEntity<ProjectTask> changeStatusTask(Long idTask, String projectIdentifier);
=======
	Response changeStatusTask(Long idTask, String projectIdentifier);
	
	List<ProjectTask> findAll(); 
>>>>>>> 2a2ec10 (Finalizacion del service de projectTask, ajustar su create y ajuste del test al repository)
}
