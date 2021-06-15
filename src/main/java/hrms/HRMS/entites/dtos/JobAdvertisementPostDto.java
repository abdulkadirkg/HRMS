package hrms.HRMS.entites.dtos;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import hrms.HRMS.entites.concretes.City;
import hrms.HRMS.entites.concretes.JobType;
import hrms.HRMS.entites.concretes.Position;

public class JobAdvertisementPostDto {
	public JobAdvertisementPostDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JobAdvertisementPostDto(@NotBlank City city, @NotBlank Position position, @NotBlank JobType jobType,
			@NotBlank String jobDescription, Double salaryMax, Double salaryMin, @NotBlank int positionCount,
			@NotBlank Date applicationDeadline, @NotBlank Boolean isActive) {
		super();
		this.city = city;
		this.position = position;
		this.jobType = jobType;
		this.jobDescription = jobDescription;
		this.salaryMax = salaryMax;
		this.salaryMin = salaryMin;
		this.positionCount = positionCount;
		this.applicationDeadline = applicationDeadline;
		this.isActive = isActive;
	}

	@NotNull
	City city;
	
	@NotNull
	Position position;
	
	@NotNull
	JobType jobType;
	
	@NotNull
	String jobDescription;

	Double salaryMax;

	Double salaryMin;
	
	int positionCount;

	Date applicationDeadline;
	
	@NotNull
	Boolean isActive = true;

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public JobType getJobType() {
		return jobType;
	}

	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
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

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
}
