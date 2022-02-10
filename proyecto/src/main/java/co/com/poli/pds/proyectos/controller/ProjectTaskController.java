package co.com.poli.pds.proyectos.controller;

import java.util.List;

<<<<<<< HEAD
=======
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
=======
>>>>>>> 4565123 (Unificacion del Projecto)
>>>>>>> main
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.poli.pds.proyectos.entity.ProjectTask;
import co.com.poli.pds.proyectos.helper.ResponseBuilder;
import co.com.poli.pds.proyectos.model.Response;
import co.com.poli.pds.proyectos.repository.ProjectTaskRepository;
import co.com.poli.pds.proyectos.service.ProjectTaskService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class ProjectTaskController {

<<<<<<< HEAD
	private final ResponseBuilder builder;
	private final ProjectTaskService projectTaskService;
	
=======
<<<<<<< HEAD
	private ResponseBuilder builder;

	@Autowired
	private ProjectTaskService projectTaskService;
<<<<<<< HEAD
=======
	private final ResponseBuilder builder;
	private final ProjectTaskService projectTaskService;
>>>>>>> 4565123 (Unificacion del Projecto)
	
<<<<<<< HEAD
<<<<<<< HEAD
=======

	@Autowired
>>>>>>> devJuan
=======
	@Autowired
>>>>>>> parent of df29d2c (Arreglar createTask)
=======
	@Autowired
>>>>>>> parent of df29d2c (Arreglar createTask)
>>>>>>> main
	private ProjectTaskRepository repository;

	@PostMapping
	public Response createTask(@RequestBody ProjectTask newTask) {
<<<<<<< HEAD
=======
<<<<<<< HEAD
		boolean flag = projectTaskService.createTask(newTask);
		if(flag) {
			return builder.success(newTask);
		}else {
			return builder.failed(newTask); 
		}
		
=======
>>>>>>> main
			boolean flag =projectTaskService.createTask(newTask);
			if(flag) {
				return builder.success(newTask);
			}else {
				return builder.failed(newTask);
			}
		  
<<<<<<< HEAD
=======
>>>>>>> 4565123 (Unificacion del Projecto)
>>>>>>> main
	}
	
	@GetMapping("/identifier/{projectIdentifier}")
	public List<ProjectTask> findAllProjectIdentifier(@PathVariable("projectIdentifier") String project){
		return repository.findByProjectIdentifier(project);
	}
	@GetMapping
	public List<ProjectTask> findAll() {
		return projectTaskService.findAll();
	}
	
	@GetMapping("hours/project/{projectIdentifier}")
	public Double allHoursProject(@PathVariable("projectIdentifier") String projectIdentifier) {
		return projectTaskService.allHoursProject(projectIdentifier);
	}

	@GetMapping("hours/project/{projectIdentifier}/{status}")
<<<<<<< HEAD
	public Double AllHoursxStatus(@PathVariable("projectIdentifier") String projectIdentifier, @PathVariable("status") String status) {
		return projectTaskService.AllHoursxStatus(projectIdentifier, status);
=======
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
	public Double AllHoursxStatus(@PathVariable("projectIdentifier") String projectIdentifier, @PathVariable("status") String status) {
		return projectTaskService.AllHoursxStatus(projectIdentifier, status);
=======
	public double AllHoursxStatus(@PathVariable("projectIdentifier") String projectIdentifier, @PathVariable("status") String status) {
		return projectTaskService.AllHoursxStatus(projectIdentifier, status);

>>>>>>> devJuan
=======
=======
>>>>>>> parent of df29d2c (Arreglar createTask)
	public Response AllHoursxStatus(@PathVariable("projectIdentifier") String projectIdentifier,
			@PathVariable("status") String status) {
		//return projectTaskService.AllHoursxStatus(projectIdentifier, status);}}
		return null;
<<<<<<< HEAD
>>>>>>> parent of df29d2c (Arreglar createTask)
=======
>>>>>>> parent of df29d2c (Arreglar createTask)
>>>>>>> main
	}

	@PutMapping("/{idtask}/{projectIdentifier}")
	public Response changeStatusTask(@PathVariable("idtask") Long idTask, @PathVariable("projectIdentifier") String projectIdentifier) {
		List<ProjectTask> borradoLogico = projectTaskService.findAll();

		for (ProjectTask prjs : borradoLogico) {
			if (prjs.getId() == idTask && prjs.getProjectIdentifier() == projectIdentifier) {
				prjs.setStatus("deleted");
				return builder.success(borradoLogico);
			} else {
				return builder.failed(borradoLogico);
			}
		}
		return builder.failed(borradoLogico);
	}

}