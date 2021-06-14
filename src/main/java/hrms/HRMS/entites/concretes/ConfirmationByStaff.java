package hrms.HRMS.entites.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "confirmationByStaff")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "employer","jobAdvertisement" })
public class ConfirmationByStaff {
	public ConfirmationByStaff(int id, boolean isConfirmed, Employer employer, JobAdvertisement jobAdvertisement) {
		super();
		this.id = id;
		this.isConfirmed = isConfirmed;
		this.employer = employer;
		this.jobAdvertisement = jobAdvertisement;
	}

	public ConfirmationByStaff() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	@Column(name = "is_confirmed", columnDefinition = "boolean default false")
	boolean isConfirmed = false;

	@OneToOne(mappedBy = "confirmationByStaff")
	Employer employer;

	@OneToOne(mappedBy = "confirmationByStaff")
	JobAdvertisement jobAdvertisement;

	public int getId() {
		return id;
	}

	public void setId(int id) { 
		this.id = id;
	}

	public boolean isConfirmed() {
		return isConfirmed;
	}

	public void setConfirmed(boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public JobAdvertisement getJobAdvertisement() {
		return jobAdvertisement;
	}

	public void setJobAdvertisement(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisement = jobAdvertisement;
	}
}
