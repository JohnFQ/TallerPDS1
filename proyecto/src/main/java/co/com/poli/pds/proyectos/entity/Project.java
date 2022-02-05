package co.com.poli.pds.proyectos.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "projects")
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "projectName")
	private String projectName;
	
	@Column(name = "projectIdentifier")
	private String projectIdentifier;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "startDate")
	@JsonFormat(pattern="yyyy-MM-dd' 'HH:mm:ss")
	private Date startDate;
	
	@Column(name = "endDate")
	@JsonFormat(pattern="yyyy-MM-dd' 'HH:mm:ss")
	private Date endDate;
	

	@OneToOne(mappedBy = "project", cascade = CascadeType.PERSIST)
	private BackLog backLog;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectIdentifier() {
		return projectIdentifier;
	}
	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/*
	public BackLog getBackLog() {
		return backLog;
	}
	public void setBackLog(BackLog backLog) {
		this.backLog = backLog;
	}
	*/
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		return Objects.equals(id, other.id);
	}
	
	
	

}
