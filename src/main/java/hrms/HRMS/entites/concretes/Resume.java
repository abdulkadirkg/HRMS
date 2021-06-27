package hrms.HRMS.entites.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "resumes")
public class Resume {
	public Resume() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Resume(int id, @NotBlank String resumeText, Boolean isActive, Candidate candidate) {
		super();
		this.id = id;
		this.resumeText = resumeText;
		this.isActive = isActive;
		this.candidate = candidate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",unique = true)
	int id;
	@NotBlank
	@NotNull
	@Column(name = "resume_text", columnDefinition="TEXT")
	String resumeText;
	
	@Column(name = "is_active")
	Boolean isActive;
	
	@JoinColumn(name = "candidate_id")
	@ManyToOne(fetch = FetchType.LAZY)
//	@JsonIgnore
	Candidate candidate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResumeText() {
		return resumeText;
	}

	public void setResumeText(String resumeText) {
		this.resumeText = resumeText;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Candidate getCandidate() {  
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
}
