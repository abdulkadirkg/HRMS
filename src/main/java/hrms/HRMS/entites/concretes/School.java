package hrms.HRMS.entites.concretes;

import java.util.Date;

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

import com.sun.istack.NotNull;

@Entity
@Table(name="schools")
public class School {
	public School() {
		super();
		// TODO Auto-generated constructor stub
	}

	public School(int id, @NotBlank String schoolName, @NotBlank String departmentName, @NotBlank Date startDate,
			Date endDate, Candidate candidate) {
		super();
		this.id = id;
		this.schoolName = schoolName;
		this.departmentName = departmentName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.candidate = candidate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	
	@NotNull
	@NotBlank
	@Column(name = "school_name")
	String schoolName;
	
	@NotNull
	@NotBlank
	@Column(name = "department")
	String departmentName;
	
	@NotNull
	@NotBlank
	@Column(name = "start_date")
	Date startDate;
	
	@Column(name = "end_date")
	Date endDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "candidate_id")
	Candidate candidate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
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
