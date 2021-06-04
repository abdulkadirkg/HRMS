package hrms.HRMS.entites.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "job_advertisements")
public class JobAdvertisement {
	public JobAdvertisement(int id, String jobDescription, City city, Position position, Double salaryMax,
			Double salaryMin, int positionCount, Date applicationDeadline, Date createdAt, Date updatedAt,
			Date deletedAt, Boolean isActive) {
		super();
		this.id = id;
		this.jobDescription = jobDescription;
		this.city = city;
		this.position = position;
		this.salaryMax = salaryMax;
		this.salaryMin = salaryMin;
		this.positionCount = positionCount;
		this.applicationDeadline = applicationDeadline;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
		this.isActive = isActive;
	}

	public JobAdvertisement() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;

	@Column(name = "job_description")
	String jobDescription;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id", referencedColumnName = "id")
	City city;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "position_id")
	Position position;

	@Column(name = "salary_max")
	Double salaryMax;

	@Column(name = "salary_min")
	Double salaryMin;

	@Column(name = "position_count")
	int positionCount;

	@Column(name = "application_deadline")
	Date applicationDeadline;

	@Column(name = "created_at")
	Date createdAt = new Date();

	@Column(name = "updated_at")
	Date updatedAt = new Date();

	@Column(name = "deleted_at")
	Date deletedAt = new Date();

	@Column(name = "is_active")
	Boolean isActive;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Double getSalaryMax() {
		return salaryMax;
	}

	public void setSalaryMax(Double salaryMax) {
		this.salaryMax = salaryMax;
	}

	public Double getSalaryMin() {
		return salaryMin;
	}

	public void setSalaryMin(Double salaryMin) {
		this.salaryMin = salaryMin;
	}

	public int getPositionCount() {
		return positionCount;
	}

	public void setPositionCount(int positionCount) {
		this.positionCount = positionCount;
	}

	public Date getApplicationDeadline() {
		return applicationDeadline;
	}

	public void setApplicationDeadline(Date applicationDeadline) {
		this.applicationDeadline = applicationDeadline;
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

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
}