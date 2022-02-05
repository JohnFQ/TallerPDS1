package co.com.poli.pds.proyectos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.poli.pds.proyectos.entity.BackLog;
import co.com.poli.pds.proyectos.helper.ResponseBuilder;
import co.com.poli.pds.proyectos.model.Response;
import co.com.poli.pds.proyectos.service.BackLogService;

@RestController
@RequestMapping("/backlogs")
public class BackLogController {
	
	@Autowired
	private BackLogService backLogService;
	
	@Autowired
	private ResponseBuilder builder;
	
	@PostMapping
	public Response createBackLog(@RequestBody BackLog newBackLog){
		return builder.success();
	}
}
