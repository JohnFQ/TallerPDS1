package co.com.poli.pds.proyectos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import co.com.poli.pds.proyectos.entity.BackLog;
import co.com.poli.pds.proyectos.repository.BackLogRepository;

@Service
@RequestMapping("/backlog")
@CrossOrigin //Para manejar las solicitudes cruzadas que provienen del navegador del cliente
public class BackLogServiceImpl implements BackLogService {

	@Autowired
	private BackLogRepository backLogRepository;
	
	
	@Override
	@PostMapping
	public ResponseEntity<BackLog> createBackLog(@RequestBody BackLog newBackLog) {
		if(newBackLog.getIdentifier() == "" ) {
			return new ResponseEntity<BackLog>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<BackLog>(backLogRepository.save(newBackLog),HttpStatus.CREATED);
	}


	@Override
	@GetMapping
	public List<BackLog> consultarBackLog() {
		return backLogRepository.findAll();
	}

}
