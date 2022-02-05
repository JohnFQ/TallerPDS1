package co.com.poli.pds.proyectos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.poli.pds.proyectos.entity.Project;
import co.com.poli.pds.proyectos.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@CrossOrigin
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;

	@Override
	@PostMapping
	@Transactional(rollbackFor = Exception.class)
	public ResponseEntity<Project> createProject(@RequestBody Project newProject) {
		if(!this.verificarIngesta(newProject)) {
			return new ResponseEntity<Project>(HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<Project>(projectRepository.save(newProject), HttpStatus.CREATED);
		}
	}

	@Override
	@GetMapping
	@Transactional(readOnly = true)
	public List<Project> viewProject() {
		return projectRepository.findAll();
	}
	
	private boolean verificarIngesta(Project newProject) {
		if(newProject.getProjectName() == "" && newProject.getProjectIdentifier() == "" && newProject.getDescription() == "") {
			return false; 
		}else {
			return true;
		}	
	}
	
}
