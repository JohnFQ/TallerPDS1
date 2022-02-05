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
import co.com.poli.pds.proyectos.repository.BackLogRepository;
import co.com.poli.pds.proyectos.repository.ProjectTaskRepository;
import lombok.RequiredArgsConstructor;

@Service
@CrossOrigin //Para manejar las solicitudes cruzadas que provienen del navegador del cliente
public class ProjectTaskServiceImpl implements ProjectTaskService{
	
	@Autowired
	private ProjectTaskRepository projectTaskRepository;
	
	@Autowired
	private BackLogRepository backLogRepository;

	@Override
	@PostMapping
	@Transactional(rollbackFor = Exception.class)
	public ResponseEntity<ProjectTask> createTask(@RequestBody ProjectTask newTask) {
		if(this.verificarIngesta(newTask) && this.verificarStatus(newTask.getStatus())) {
			return new ResponseEntity<ProjectTask>(projectTaskRepository.save(newTask), HttpStatus.CREATED);
		}else {
			return new ResponseEntity<ProjectTask>(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	@GetMapping
	public List<ProjectTask> viewAllTaskProject(Integer projectIdentifier) {
		return projectTaskRepository.findAll();
	}

	@Override
	@GetMapping(path = "/{idProjectIdentifier}")
	public Double allHoursProject(@PathVariable ("idProjectIdentifier") String projectIdentifier) {
			//Optional<ProjectTask> hoursProject = projectTaskRepository.findById(projectIdentifier);
			
		return 0.0;
	}

	@Override
	@GetMapping(path = "/{idProjectIdentifier}/{status}")
	public Double AllHoursxStatus(@PathVariable ("idProjectIdentifier") String projectIdentifier, @PathVariable ("status") String status) {
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
	@PutMapping(path = "/{idTask}/{projectId}")
	public ResponseEntity<ProjectTask> changeStatusTask(@PathVariable ("idTask") Long idTask,@PathVariable ("projectId") String projectIdentifier) {
		Optional<ProjectTask> borradoLogico = projectTaskRepository.findById(idTask);
		
		if(borradoLogico.isPresent() && borradoLogico.get().getProjectIdentifier().equals(projectIdentifier)) {
			borradoLogico.get().setStatus("deleted");
			return new ResponseEntity<ProjectTask>(HttpStatus.OK);
		}else {
			return new ResponseEntity<ProjectTask>(HttpStatus.BAD_REQUEST);
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
