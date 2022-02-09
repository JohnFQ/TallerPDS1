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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import co.com.poli.pds.proyectos.entity.BackLog;
import co.com.poli.pds.proyectos.entity.Project;
import co.com.poli.pds.proyectos.entity.ProjectTask;
import co.com.poli.pds.proyectos.repository.BackLogRepository;
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

	@Override
<<<<<<< HEAD
    @Transactional(rollbackFor = Exception.class)
    public void save(BackLog backlog) {
		backLogRepository.save(backlog);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(BackLog backlog) {
    	backLogRepository.delete(backlog);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BackLog> findAll() {
        return backLogRepository.findAll();
    }


    @Override
    @Transactional(readOnly = true)
    public BackLog findById(Long id) {
        return backLogRepository.findById(id).orElse(null);
    }

	
=======
	@Transactional(rollbackFor = Exception.class)
	public ResponseEntity<BackLog> createBackLog(BackLog newBackLog) {
		List<ProjectTask> tasks = newBackLog.getProjectTask();

		newBackLog.setProjectTask(null);

		for (ProjectTask task : tasks) {
			task.setId(newBackLog.getId());
		}

		projectTaskRepository.saveAll(tasks);

		if (newBackLog.getIdentifier() == "") {
			return new ResponseEntity<BackLog>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<BackLog>(backLogRepository.save(newBackLog), HttpStatus.CREATED);
	}

	@Override
	public List<BackLog> consultarBackLog() {
		return backLogRepository.findAll();
	}

>>>>>>> main
}
