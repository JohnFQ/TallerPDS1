package co.com.poli.pds.proyectos.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import co.com.poli.pds.proyectos.entity.Project;
import co.com.poli.pds.proyectos.model.Response;

@Service
@RequestMapping("/project")
@CrossOrigin //Para manejar las solicitudes cruzadas que provienen del navegador del cliente
public interface ProjectService {

<<<<<<< HEAD
	boolean save(Project product);
    void delete(Project product);
=======
	Response save(Project product);
    Response delete(Project product);
>>>>>>> main
    List<Project> findAll();
    Project findById(Long id);
	boolean verificarIngesta(Project project);
	
}
