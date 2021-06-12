package hrms.HRMS.entites.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "job_types")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisement"})
public class JobType {
	public JobType(int id, String jobType, boolean isActive, List<JobAdvertisement> jobAdvertisement) {
		super();
		this.id = id;
		this.jobType = jobType;
		this.isActive = isActive;
		this.jobAdvertisement = jobAdvertisement;
	}

	public JobType() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column(name = "job_type")
	String jobType;
	@Column(name = "is_active")
	boolean isActive;

	@OneToMany(mappedBy = "jobType")
	@JsonIgnore
	List<JobAdvertisement> jobAdvertisement;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public List<JobAdvertisement> getJobAdvertisement() {
		return jobAdvertisement;
	}

	public void setJobAdvertisement(List<JobAdvertisement> jobAdvertisement) {
		this.jobAdvertisement = jobAdvertisement;
	}

}
