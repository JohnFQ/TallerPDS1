package co.com.poli.pds.proyectos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import co.com.poli.pds.proyectos.entity.BackLog;
import co.com.poli.pds.proyectos.entity.Project;
import co.com.poli.pds.proyectos.entity.ProjectTask;
import co.com.poli.pds.proyectos.repository.BackLogRepository;
import co.com.poli.pds.proyectos.repository.ProjectRepository;
import co.com.poli.pds.proyectos.repository.ProjectTaskRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@CrossOrigin // Para manejar las solicitudes cruzadas que provienen del navegador del cliente
public class BackLogServiceImpl implements BackLogService {
	
	@Autowired
	private BackLogRepository backLogRepository;
	
	@Autowired
	private ProjectTaskRepository projectTaskRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Override
	public boolean save(BackLog backlog) {
		backLogRepository.save(backlog);
		return true;
	}

	@Override
	public void delete(BackLog backlog) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BackLog> findAll() {
		return backLogRepository.findAll();
		
	}

	@Override
	@Transactional(readOnly = true)
	public BackLog findById(Long id) {
		return backLogRepository.findById(id).orElse(null);
	}
/*
	private boolean verificarExistenciaProject(Long idBackLog, Long idProject) {
		Optional<Project> projects = projectRepository.findById(idProject);
		if(projects.isPresent()) {
			if(projects.get().getBackLog() == null) {
				projects.get().;
			}
		}
	}
	*/
}
