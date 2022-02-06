package co.com.poli.pds.proyectos.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import co.com.poli.pds.proyectos.entity.Project;
import co.com.poli.pds.proyectos.helper.ResponseBuilder;
import co.com.poli.pds.proyectos.model.Response;
import co.com.poli.pds.proyectos.service.ProjectService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {

	private final ProjectService projectService;
	private final ResponseBuilder builder;

	@PostMapping
	public Response save(@Validated @RequestBody Project project, BindingResult result) {

		if (result.hasErrors() || !verificarIngesta(project)) {
			return builder.failed(formatMessage(result));
		} else {
			List<Project> projectsAll = projectService.findAll();
			for (Project projectValid : projectsAll) {
				if (projectValid.getProjectIdentifier().toUpperCase().equals(project.getProjectIdentifier().toUpperCase())
						|| projectValid.getProjectName().toUpperCase().equals(project.getProjectName().toUpperCase())) {
					return builder.failed(formatMessage(result));
				}
			}
			projectService.save(project);
			return builder.success(project);
		}

	}

	private List<Map<String, String>> formatMessage(BindingResult result) {
		List<Map<String, String>> errors = result.getFieldErrors().stream().map(err -> {
			Map<String, String> error = new HashMap<>();
			error.put(err.getField(), err.getDefaultMessage());
			return error;
		}).collect(Collectors.toList());
		return errors;
	}

	private boolean verificarIngesta(Project newProject) {
		System.out.println(newProject.getProjectIdentifier());
		if (newProject.getProjectName() == "" || newProject.getProjectIdentifier() == ""
				|| newProject.getDescription() == "") {
			return false;
		} else {
			return true;
		}
	}
}
