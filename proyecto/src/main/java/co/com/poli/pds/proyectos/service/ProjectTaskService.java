package co.com.poli.pds.proyectos.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import co.com.poli.pds.proyectos.entity.ProjectTask;
import co.com.poli.pds.proyectos.model.Response;

public interface ProjectTaskService {
	
<<<<<<< HEAD
<<<<<<< HEAD
	ResponseEntity<ProjectTask> createTask(ProjectTask newTask);
=======
	void createTask(ProjectTask newTask);
>>>>>>> 2a2ec10 (Finalizacion del service de projectTask, ajustar su create y ajuste del test al repository)
=======
	boolean createTask(ProjectTask newTask);
>>>>>>> main
	
	List<ProjectTask> viewAllTaskProject(String projectIdentifier);
	
	Response allHoursProject(String projectIdentifier);
	
	Response AllHoursxStatus(String projectIdentifier, String status);
	
<<<<<<< HEAD
<<<<<<< HEAD
	ResponseEntity<ProjectTask> changeStatusTask(Long idTask, String projectIdentifier);
=======
	Response changeStatusTask(Long idTask, String projectIdentifier);
	
	List<ProjectTask> findAll(); 
>>>>>>> 2a2ec10 (Finalizacion del service de projectTask, ajustar su create y ajuste del test al repository)
=======
	Response changeStatusTask(Long idTask, String projectIdentifier);
	
	List<ProjectTask> findAll(); 
>>>>>>> main
}
