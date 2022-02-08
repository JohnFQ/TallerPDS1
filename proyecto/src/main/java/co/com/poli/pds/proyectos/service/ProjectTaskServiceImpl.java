package co.com.poli.pds.proyectos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.poli.pds.proyectos.entity.BackLog;
import co.com.poli.pds.proyectos.entity.ProjectTask;
import co.com.poli.pds.proyectos.helper.ResponseBuilder;
import co.com.poli.pds.proyectos.model.Response;
import co.com.poli.pds.proyectos.repository.BackLogRepository;
import co.com.poli.pds.proyectos.repository.ProjectTaskRepository;
import lombok.RequiredArgsConstructor;

@Service
@CrossOrigin //Para manejar las solicitudes cruzadas que provienen del navegador del cliente
public class ProjectTaskServiceImpl implements ProjectTaskService{
	
	private  ProjectService projectService;
	
	private  ResponseBuilder builder;
	
	@Autowired
	private ProjectTaskRepository projectTaskRepository;
	
	@Autowired
	private BackLogRepository backLogRepository;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Response createTask(@RequestBody ProjectTask newTask) {
		if(this.verificarIngesta(newTask) && this.verificarStatus(newTask.getStatus())) {
			projectTaskRepository.save(newTask);
			return builder.success(newTask);
		}else {
			return builder.failed(newTask);
		}
	}

	@Override
	public List<ProjectTask> viewAllTaskProject(Integer projectIdentifier) {
		return projectTaskRepository.findAll();
	}

	@Override
	public Double allHoursProject(String projectIdentifier) {
			//Optional<ProjectTask> hoursProject = projectTaskRepository.findById(projectIdentifier);
			
		return 0.0;
	}

	@Override
	public Double AllHoursxStatus(String projectIdentifier, @PathVariable ("status") String status) {
		List<ProjectTask> projectTaskList = projectTaskRepository.findByProjectIdentifier(projectIdentifier);
		if(this.verificarStatus(status) && status != "deleted") {
			for(ProjectTask tasks : projectTaskList) {
				Double contTasks = tasks.getHours();
				contTasks += contTasks;
				return contTasks;
			}
		}
		return 0.0;
	}

	@Override
	public Response changeStatusTask(Long idTask,String projectIdentifier) {
		Optional<ProjectTask> borradoLogico = projectTaskRepository.findById(idTask);
		
		if(borradoLogico.isPresent() && borradoLogico.get().getProjectIdentifier().equals(projectIdentifier)) {
			borradoLogico.get().setStatus("deleted");
			return builder.success(borradoLogico);
		}else {
			return builder.failed(borradoLogico);
		}
	}
	
	private boolean verificarIngesta(ProjectTask validate) {
		if(validate.getName() == "" && validate.getProjectIdentifier() == "" && validate.getSumary() == "" &&
				validate.getStatus() == "") {
			return false;
		}else if(validate.getPriority()>= 1 && validate.getPriority() <= 5 && validate.getHours() >=1 && validate.getHours() <= 8){
			return true;
		}else {
			return false;
		}
	}
	
	private boolean verificarStatus(String nameStatus) {
		if(nameStatus != "Not Started" || nameStatus != "in progress" || nameStatus != "completed" || nameStatus != "deleted") {
			return false;
		}else {
			return true;
		}
	}

}
