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
	
<<<<<<< HEAD
<<<<<<< HEAD
=======
	
	private  ResponseBuilder builder;
	
>>>>>>> 2a2ec10 (Finalizacion del service de projectTask, ajustar su create y ajuste del test al repository)
=======
	
	private  ResponseBuilder builder;
	
>>>>>>> main
	@Autowired
	private ProjectTaskRepository projectTaskRepository;
	

	@Override
	@Transactional(rollbackFor = Exception.class)
<<<<<<< HEAD
<<<<<<< HEAD
	public ResponseEntity<ProjectTask> createTask(@RequestBody ProjectTask newTask) {
		if(this.verificarIngesta(newTask) && this.verificarStatus(newTask.getStatus())) {
			return new ResponseEntity<ProjectTask>(projectTaskRepository.save(newTask), HttpStatus.CREATED);
		}else {
			return new ResponseEntity<ProjectTask>(HttpStatus.BAD_REQUEST);
		}
=======
	public boolean createTask(ProjectTask newTask) {
			if(this.verificarIngesta(newTask) && !this.verificarStatus(newTask.getStatus())) {
				projectTaskRepository.save(newTask); 
				return true;
			}else {
				return false;
			}
>>>>>>> main
	}


	@Override
<<<<<<< HEAD
	@GetMapping(path = "/{idProjectIdentifier}")
	public Double allHoursProject(@PathVariable ("idProjectIdentifier") String projectIdentifier) {
			//Optional<ProjectTask> hoursProject = projectTaskRepository.findById(projectIdentifier);
=======
	public void createTask(@RequestBody ProjectTask newTask) {
			projectTaskRepository.save(newTask);
	}


	@Override
	@Transactional(readOnly = true)
	public Response allHoursProject(String projectIdentifier) {
			List<ProjectTask> projects = projectTaskRepository.findByProjectIdentifier(projectIdentifier);
			
			for(ProjectTask projectTaskIdentifier : projects) {
				if(this.verificarStatus(projectTaskIdentifier.getStatus()) && projectTaskIdentifier.getStatus() != "deleted") {
					Double contTasks = projectTaskIdentifier.getHours();
					contTasks += contTasks;
					return builder.succes(contTasks);
				}
			}
>>>>>>> 2a2ec10 (Finalizacion del service de projectTask, ajustar su create y ajuste del test al repository)
			
		return builder.failedClean();
	}

	@Override
<<<<<<< HEAD
	@GetMapping(path = "/{idProjectIdentifier}/{status}")
	public Double AllHoursxStatus(@PathVariable ("idProjectIdentifier") String projectIdentifier, @PathVariable ("status") String status) {
=======
	@Transactional(readOnly = true)
	public Response AllHoursxStatus(String projectIdentifier, String status) {
>>>>>>> 2a2ec10 (Finalizacion del service de projectTask, ajustar su create y ajuste del test al repository)
		List<ProjectTask> projectTaskList = projectTaskRepository.findByProjectIdentifier(projectIdentifier);
		
		if(this.verificarStatus(status)) {
=======
	@Transactional(readOnly = true)
	public Double allHoursProject(String projectIdentifier) {
			List<ProjectTask> projects = projectTaskRepository.findByProjectIdentifier(projectIdentifier);
			Double contTasks = 0D, contFlag = 0D;
			for(ProjectTask projectTaskIdentifier : projects) {
				if(!this.verificarStatus(projectTaskIdentifier.getStatus()) && projectTaskIdentifier.getStatus() != "deleted") {
					contTasks = projectTaskIdentifier.getHours();
					
				}
				
			}
				
			
			
			
		return contTasks;
	}

	@Override
	@Transactional(readOnly = true)
	public Double AllHoursxStatus(String projectIdentifier, String status) {
		List<ProjectTask> projectTaskList = projectTaskRepository.findByProjectIdentifier(projectIdentifier);
		Double contTasks = 0D;
		if(!this.verificarStatus(status)) {
>>>>>>> main
			for(ProjectTask tasks : projectTaskList) {
				contTasks = tasks.getHours();
				contTasks += contTasks;
				return builder.succes(contTasks);
			}
		}
<<<<<<< HEAD
		return builder.failedClean();
=======
		return contTasks;
>>>>>>> main
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<ProjectTask> viewAllTaskProject(String projectIdentifier) {
		return projectTaskRepository.findByProjectIdentifier(projectIdentifier);
	}

	@Override
<<<<<<< HEAD
<<<<<<< HEAD
	@PutMapping(path = "/{idTask}/{projectId}")
	public ResponseEntity<ProjectTask> changeStatusTask(@PathVariable ("idTask") Long idTask,@PathVariable ("projectId") String projectIdentifier) {
=======
=======
>>>>>>> main
	@Transactional(readOnly = true)
	public List<ProjectTask> findAll() {
		return projectTaskRepository.findAll();
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Response changeStatusTask(Long idTask,String projectIdentifier) {
<<<<<<< HEAD
>>>>>>> 2a2ec10 (Finalizacion del service de projectTask, ajustar su create y ajuste del test al repository)
=======
>>>>>>> main
		Optional<ProjectTask> borradoLogico = projectTaskRepository.findById(idTask);
		
		if(borradoLogico.isPresent() && borradoLogico.get().getProjectIdentifier().equals(projectIdentifier)) {
			borradoLogico.get().setStatus("deleted");
			return builder.success(borradoLogico);
		}else {
			return builder.failed(borradoLogico);
		}
	}
	
	private boolean verificarIngesta(ProjectTask validate) {
		if(validate.getName() == "" || validate.getProjectIdentifier() == "" || validate.getSumary() == "" ||
				validate.getStatus() == "") {
			return false;
		}else if(validate.getPriority()>= 1 || validate.getPriority() <= 5 && validate.getHours() >=1 || validate.getHours() <= 8){
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
