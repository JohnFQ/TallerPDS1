package co.com.poli.pds.proyectos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import co.com.poli.pds.proyectos.entity.Project;
import co.com.poli.pds.proyectos.entity.ProjectTask;
import co.com.poli.pds.proyectos.repository.ProjectTaskRepository;

@Service
@RequestMapping("/projectTask")
@CrossOrigin //Para manejar las solicitudes cruzadas que provienen del navegador del cliente
public class ProjectTaskServiceImpl implements ProjectTaskService{
	
	@Autowired
	private ProjectTaskRepository projectTaskRepository;

	@Override
	public ProjectTask createTask(ProjectTask newTask) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProjectTask> viewAllTaskProject(int projectIdentifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int allHoursProject(int projectIdentifier) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int AllHoursxStatus(int projectIdentifier, String status) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean changeStatusTask(int idTask, int projectIdentifier) {
		// TODO Auto-generated method stub
		return false;
	}
	


}
