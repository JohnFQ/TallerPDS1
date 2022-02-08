package co.com.poli.pds.proyectos;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import co.com.poli.pds.proyectos.entity.BackLog;
import co.com.poli.pds.proyectos.entity.ProjectTask;
import co.com.poli.pds.proyectos.repository.BackLogRepository;
import co.com.poli.pds.proyectos.repository.ProjectTaskRepository;

@DataJpaTest
public class ProjectTaskRepositoryMockTest {
	
	@Autowired
	private ProjectTaskRepository projectTaskRepository;
	
	@Test
	public void when_findByProjectIdentifier_return_ListProjectIdentifier() {
		
		ProjectTask project = ProjectTask.builder()
										.name("Tarea programada")
										.acceptanceCriteria("Criterios de busqueda")
										.status("Not Started")
										.priority(3)
										.hours(5.0)
										.startDate(new Date())
										.endDate(new Date())
										.projectIdentifier("PPI")
										.backLog(BackLog.builder().id(1L).build())
										.build();
		List<ProjectTask> projects = projectTaskRepository.findByProjectIdentifier(project.getProjectIdentifier());
		
		Assertions.assertThat(projects.size()).isEqualTo();
	}
	
	/*
	 * @Column(name = "name")
	private String name;
	
	@Column(name = "sumary")
	private String sumary;
	
	@Column(name = "acceptanceCriteria")
	private String acceptanceCriteria;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "priority")
	private Integer priority;
	
	@Column(name = "hours")
	private Double hours;
	
	@JsonFormat(pattern="yyyy-MM-dd' 'HH:mm:ss")
	@Column(name = "startDate")
	private Date startDate;
	
	@JsonFormat(pattern="yyyy-MM-dd' 'HH:mm:ss")
	@Column(name = "endDate")
	private Date endDate;
	
	@Column(name = "projectIdentifier")
	private String projectIdentifier;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name=" backLog_id")
	private BackLog backLog;
	 */
}
