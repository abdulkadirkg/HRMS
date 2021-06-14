package hrms.HRMS.entites.concretes;

import java.util.UUID;

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
@Table(name = "confirmationByMail")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "employer" })
public class ConfirmationByMail {
	public ConfirmationByMail() {
		super();
		setConfirmationCode(UUID.randomUUID().toString());
	}

	public ConfirmationByMail(int id, String confirmationCode, boolean isConfirmed, Employer employer) {
		super();
		this.id = id;
		this.confirmationCode = confirmationCode;
		this.isConfirmed = isConfirmed;
		this.employer = employer;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	@Column(name = "confirmation_code")
	String confirmationCode;
	@Column(name = "is_confirmed", columnDefinition = "boolean default false")
	boolean isConfirmed;
	@OneToOne(mappedBy = "confirmationByMail")
	Employer employer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConfirmationCode() {
		return confirmationCode;
	}

	public void setConfirmationCode(String confirmationCode) {
		this.confirmationCode = confirmationCode;
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
}
