package co.com.poli.pds.proyectos;

import java.util.Date;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import co.com.poli.pds.proyectos.entity.BackLog;
import co.com.poli.pds.proyectos.entity.ProjectTask;
import co.com.poli.pds.proyectos.repository.BackLogRepository;
import co.com.poli.pds.proyectos.repository.ProjectTaskRepository;

@DataJpaTest
public class ProjectTaskRepositoryMockTest {
	
	@Autowired
	private ProjectTaskRepository projectTaskRespository;
	
	@Autowired
	private BackLogRepository backLogRepository;
	
	@Test
	public void when_findByProjectIdentifier_return_ListProjectIdentifier() {
		
		BackLog bck = backLogRepository.getById(1L);
		
		ProjectTask pTask = new ProjectTask("ProyectoBackend", "proyecto de prueba backend", "Que el backend save",
				"Not Started", 2, 3D, null, null, "BACK", bck);
		
		projectTaskRespository.save(pTask);
		
		List<ProjectTask> tasks = projectTaskRespository.findByProjectIdentifier(pTask.getProjectIdentifier());
		
		
<<<<<<< HEAD
=======
		Assertions.assertThat(projects.size()).isEqualTo(0);
>>>>>>> 2a2ec10 (Finalizacion del service de projectTask, ajustar su create y ajuste del test al repository)
	}
}
