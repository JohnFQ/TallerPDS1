package co.com.poli.pds.proyectos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
import co.com.poli.pds.proyectos.service.ProjectTaskService;

@RestController
@RequestMapping("/task")
public class ProjectTaskController {

	private ResponseBuilder builder;

	@Autowired
	private ProjectTaskService projectTaskService;

	@PostMapping
	public Response createTask(@RequestBody ProjectTask newTask) {
		projectTaskService.createTask(newTask);
		return builder.success(newTask);

		/*
		 * if(this.verificarIngesta(newTask) &&
		 * this.verificarStatus(newTask.getStatus())) {
		 * projectTaskService.createTask(newTask); return builder.success(newTask);
		 * }else { return builder.failed(newTask); }
		 * 
		 */
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

		return builder.failedClean();
	}

	@GetMapping("hours/project/{projectIdentifier}/{status}")
	public Response AllHoursxStatus(@PathVariable("projectIdentifier") String projectIdentifier,
			@PathVariable("status") String status) {
		return projectTaskService.AllHoursxStatus(projectIdentifier, status);
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
