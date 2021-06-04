package hrms.HRMS.entites.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "positions")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","position"})
public class Position {
	public Position(int id, String jobName, Date createdAt, Date updatedAt, Date deletedAt) {
		super();
		this.id = id;
		this.jobName = jobName;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	public Position() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	@Column(name = "job_name")
	@NotNull
	@NotBlank
	String jobName;
	@Column(name = "created_at")
	@NotNull
	@NotBlank
	Date createdAt = new Date();
	@Column(name = "updated_at")
	Date updatedAt = new Date();
	@Column(name = "deleted_at")
	Date deletedAt = new Date();
	
	@OneToMany(mappedBy = "position")
	List<JobAdvertisement> jobAdvertisement;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

}
