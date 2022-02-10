package co.com.poli.pds.proyectos.controller;

import java.util.List;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
=======
>>>>>>> 4565123 (Unificacion del Projecto)
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

@RestController
@RequestMapping("/task")
public class ProjectTaskController {

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
	private ProjectTaskRepository repository;

	@PostMapping
	public Response createTask(@RequestBody ProjectTask newTask) {
<<<<<<< HEAD
		boolean flag = projectTaskService.createTask(newTask);
		if(flag) {
			return builder.success(newTask);
		}else {
			return builder.failed(newTask); 
		}
		
=======
			boolean flag =projectTaskService.createTask(newTask);
			if(flag) {
				return builder.success(newTask);
			}else {
				return builder.failed(newTask);
			}
		  
>>>>>>> 4565123 (Unificacion del Projecto)
	}
	
	@GetMapping("/identifier/{projectIdentifier}")
	public List<ProjectTask> findAllProjectIdentifier(@PathVariable("projectIdentifier") String project){
		return repository.findByProjectIdentifier(project);
	}

	@GetMapping
	public List<ProjectTask> findAll() {
		return projectTaskService.findAll();
	}


	@GetMapping("/project/{projectIdentifier}")
	public List<ProjectTask> viewAllTaskProject(@PathVariable("projectIdentifier") String projectIdentifier) {
		return projectTaskService.viewAllTaskProject(projectIdentifier);
	}

	@GetMapping("hours/project/{projectIdentifier}")
	public Response allHoursProject(@PathVariable("projectIdentifier") String projectIdentifier) {
		List<ProjectTask> projects = projectTaskService.findAll();
		for (ProjectTask projectTaskIdentifier : projects) {
			if (this.verificarStatus(projectTaskIdentifier.getStatus())
					&& projectTaskIdentifier.getStatus() != "deleted") {
				Double contTasks = projectTaskIdentifier.getHours();
				contTasks += contTasks;
				return builder.succes(contTasks);
			}
		}

		return builder.failed();
	}

	@GetMapping("hours/project/{projectIdentifier}/{status}")
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

	private boolean verificarIngesta(ProjectTask validate) {
		if (validate.getName() == "" || validate.getProjectIdentifier() == "" || validate.getSumary() == ""
				|| validate.getStatus() == "") {
			return false;
		} else if (validate.getPriority() >= 1 && validate.getPriority() <= 5 && validate.getHours() >= 1
				&& validate.getHours() <= 8) {
			return true;
		} else {
			return false;
		}
	}

	private boolean verificarStatus(String nameStatus) {
		if (nameStatus != "Not Started" || nameStatus != "in progress" || nameStatus != "completed"
				|| nameStatus != "deleted") {
			return false;
		} else {
			return true;
		}
	}
}
