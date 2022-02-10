package co.com.poli.pds.proyectos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import co.com.poli.pds.proyectos.entity.ProjectTask;
import co.com.poli.pds.proyectos.helper.ResponseBuilder;
import co.com.poli.pds.proyectos.model.Response;
import co.com.poli.pds.proyectos.repository.ProjectTaskRepository;

@Service
@CrossOrigin //Para manejar las solicitudes cruzadas que provienen del navegador del cliente
public class ProjectTaskServiceImpl implements ProjectTaskService{
	
	
	private  ResponseBuilder builder;
	
	@Autowired
	private ProjectTaskRepository projectTaskRepository;
	
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean createTask(ProjectTask newTask) {
			if(this.verificarIngesta(newTask) && !this.verificarStatus(newTask.getStatus())) {
				//projectTaskRepository.save(newTask); 
				return true;
			}else {
				return false;
			}
	}


	@Override
	@Transactional(readOnly = true)
	public Double allHoursProject(String projectIdentifier) {
			List<ProjectTask> projects = projectTaskRepository.findByProjectIdentifier(projectIdentifier);
<<<<<<< HEAD
			Double contFlag = 0D;
			for(ProjectTask projectTaskIdentifier : projects) {
				if(!projectTaskIdentifier.getStatus().equals("deleted")) {
					Double contHoras = projectTaskIdentifier.getHours();
					contFlag = contFlag + contHoras;
				}
			}
			
		return contFlag;
=======
			Double contTasks = 0D, contFlag = 0D;
			Double vectHours[];
			vectHours = new Double[projects.size()];
			
			for(ProjectTask projectTaskIdentifier : projects) {
				System.out.println(projects.size());
				if(!this.verificarStatus(projectTaskIdentifier.getStatus()) && projectTaskIdentifier.getStatus() != "deleted") {
					contTasks = projectTaskIdentifier.getHours();
					System.out.println(contTasks);
				}
				contFlag = contTasks;
			}
				
			
			System.out.println("contFlag" + contFlag);
			
		return contTasks;
>>>>>>> devJuan
	}

	@Override
	@Transactional(readOnly = true)
	public Double AllHoursxStatus(String projectIdentifier, String status) {
		List<ProjectTask> projectTaskList = projectTaskRepository.findByProjectIdentifier(projectIdentifier);
		Double contTasks = 0D, contFlag = 0D;
		if(!this.verificarStatus(status)) {
			for(ProjectTask tasks : projectTaskList) {
				if(tasks.getStatus().equals(status)) {
					contTasks = tasks.getHours();
					contFlag = contFlag +  contTasks;
				}
			}
		}
		return contFlag;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<ProjectTask> viewAllTaskProject(String projectIdentifier) {
		return projectTaskRepository.findByProjectIdentifier(projectIdentifier);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectTask> findAll() {
		return projectTaskRepository.findAll();
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
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