package hrms.HRMS.entites.concretes;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employers")
public class Employer {
	public Employer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employer(int id, String companyName, String webSite, String eMail, String phone, String password,
			ConfirmationByMail confirmationByMail, ConfirmationByStaff confirmationByStaff, Date createdAt,
			Date updatedAt, Date deletedAt) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.webSite = webSite;
		this.eMail = eMail;
		this.phone = phone;
		this.password = password;
		this.confirmationByMail = confirmationByMail;
		this.confirmationByStaff = confirmationByStaff;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	@Column(name = "company_name")
	String companyName;
	@Column(name = "web_site")
	String webSite;
	@Column(name = "e_mail")
	String eMail;
	@Column(name = "phone")
	String phone;
	@Column(name = "password")
	String password;
	@OneToOne()
	@JoinColumn(name = "mail_confirmation_id", referencedColumnName = "id")
	ConfirmationByMail confirmationByMail;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "staff_confirmation_id", referencedColumnName = "id")
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
}
