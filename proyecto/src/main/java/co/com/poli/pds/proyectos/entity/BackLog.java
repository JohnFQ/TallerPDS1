package co.com.poli.pds.proyectos.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "backlogs")
public class BackLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "identifier")
	private String identifier;
	
	@OneToOne
	@JoinColumn(name = "project_id")
	private Project project;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "backLog", cascade = CascadeType.REMOVE)
	private List<ProjectTask> projectTask;
	
	
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
		BackLog other = (BackLog) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
