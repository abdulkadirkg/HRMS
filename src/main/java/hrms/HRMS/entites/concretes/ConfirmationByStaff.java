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
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class ConfirmationByStaff {
	public ConfirmationByStaff() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConfirmationByStaff(int id, boolean isConfirmed, Employer employer) {
		super();
		this.id = id;
		this.isConfirmed = isConfirmed;
		this.employer = employer;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	@Column(name = "is_confirmed")
	boolean isConfirmed;
	@OneToOne(mappedBy = "confirmationByStaff")
	@JsonIgnore
	Employer employer;

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
}
