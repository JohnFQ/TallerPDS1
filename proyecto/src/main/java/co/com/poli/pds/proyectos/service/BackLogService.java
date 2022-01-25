package co.com.poli.pds.proyectos.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import co.com.poli.pds.proyectos.entity.BackLog;

public interface BackLogService {
	
	ResponseEntity<BackLog> createBackLog(BackLog newBackLog);
	List<BackLog> consultarBackLog();
	
}
