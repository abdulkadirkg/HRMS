package hrms.HRMS.entites.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Table(name = "job_experiences")
public class JobExperience {
	public JobExperience(int id, @NotBlank String workplace, @NotBlank String jobPosition, @NotBlank Date startDate,
			Date endDate, Candidate candidate) {
		super();
		this.id = id;
		this.workplace = workplace;
		this.jobPosition = jobPosition;
		this.startDate = startDate;
		this.endDate = endDate;
		this.candidate = candidate;
	}

	public JobExperience() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	@NotNull
	@NotBlank
	@Column(name = "workplace")
	String workplace;
	@NotNull
	@NotBlank
	@Column(name = "job_position")
	String jobPosition;
	@NotNull
	@NotBlank
	@Column(name = "start_date")
	Date startDate;

	@Column(name = "end_date")
	Date endDate;

	@ManyToOne
	@JoinColumn(name = "candidate_id")
//	@JsonIgnore
	Candidate candidate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWorkplace() {
		return workplace;
	}

	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}

	public String getJobPosition() {
		return jobPosition;
	}

	public void setJobPosition(String jobPosition) {
		this.jobPosition = jobPosition;
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

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
}
