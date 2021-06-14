package hrms.HRMS.entites.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "employers")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobAdvertisement" })
public class Employer {

	public Employer(int id, @NotBlank String companyName, @NotBlank @URL String webSite, @NotBlank @Email String eMail,
			@NotBlank String phone, @NotBlank String password, List<JobAdvertisement> jobAdvertisement,
			ConfirmationByMail confirmationByMail, ConfirmationByStaff confirmationByStaff, Date createdAt,
			Date updatedAt, Date deletedAt) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.webSite = webSite;
		this.eMail = eMail;
		this.phone = phone;
		this.password = password;
		this.jobAdvertisement = jobAdvertisement;
		this.confirmationByMail = confirmationByMail;
		this.confirmationByStaff = confirmationByStaff;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	public Employer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	@Column(name = "company_name")
	@NotNull
	@NotBlank
	String companyName;
	@Column(name = "web_site")
	@NotNull
	@NotBlank
	@URL
	String webSite;
	@NotNull
	@NotBlank
	@Email
	@Column(name = "e_mail",unique=true)
	String eMail;
	@NotNull
	@NotBlank
	@Column(name = "phone")
	String phone;
	@NotNull
	@NotBlank
	@Column(name = "password")
	String password;
	@OneToMany(mappedBy = "employer")
	@JsonIgnore
	List<JobAdvertisement> jobAdvertisement;
	@OneToOne()
	@JoinColumn(name = "mail_confirmation_id", referencedColumnName = "id")
	@JsonIgnore
	ConfirmationByMail confirmationByMail;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "staff_confirmation_id", referencedColumnName = "id")
	@JsonIgnore
	ConfirmationByStaff confirmationByStaff;
	@Column(name = "created_at")
	Date createdAt = new Date();
	@Column(name = "updated_at")
	Date updatedAt = new Date();
	@Column(name = "deleted_at")
	Date deletedAt = new Date();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ConfirmationByMail getConfirmationByMail() {
		return confirmationByMail;
	}

	public void setConfirmationByMail(ConfirmationByMail confirmationByMail) {
		this.confirmationByMail = confirmationByMail;
	}

	public ConfirmationByStaff getConfirmationByStaff() {
		return confirmationByStaff;
	}

	public void setConfirmationByStaff(ConfirmationByStaff confirmationByStaff) {
		this.confirmationByStaff = confirmationByStaff;
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

	public List<JobAdvertisement> getJobAdvertisement() {
		return jobAdvertisement;
	}

	public void setJobAdvertisement(List<JobAdvertisement> jobAdvertisement) {
		this.jobAdvertisement = jobAdvertisement;
	}

}
