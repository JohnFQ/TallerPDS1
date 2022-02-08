package co.com.poli.pds.proyectos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

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
    @Transactional(rollbackFor = Exception.class)
    public void save(Project project) {
    	projectRepository.save(project);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Project project) {
    	projectRepository.delete(project);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Project findById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }
	
}
