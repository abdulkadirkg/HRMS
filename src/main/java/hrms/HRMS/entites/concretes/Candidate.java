package hrms.HRMS.entites.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "candidates")
public class Candidate {
	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Candidate(int id, String name, String surname, String identifyNumber, int birthOfYear, String eMail,
			String password, Date createdAt, Date updatedAt, Date deletedAt, ConfirmationByMail confirmationByMail,
			ConfirmationByStaff confirmationByStaff) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.identifyNumber = identifyNumber;
		this.birthOfYear = birthOfYear;
		this.eMail = eMail;
		this.password = password;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
		this.confirmationByMail = confirmationByMail;
		this.confirmationByStaff = confirmationByStaff;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	@Column(name = "name")
	String name;
	@Column(name = "surname")
	String surname;
	@Column(name = "identify_number")
	String identifyNumber;
	@Column(name = "birth_of_year")
	int birthOfYear;
	@Column(name = "e_mail")
	String eMail;
	@Column(name = "password")
	String password;
	@Column(name = "created_at")
	Date createdAt = new Date();
	@Column(name = "updated_at")
	Date updatedAt = new Date();
	@Column(name = "deleted_at")
	Date deletedAt = new Date();
	@OneToOne()
	@JoinColumn(name = "mail_confirmation_id",referencedColumnName = "id")
	ConfirmationByMail confirmationByMail;
	@OneToOne()
	@JoinColumn(name = "staff_confirmation_id",referencedColumnName = "id")
	ConfirmationByStaff confirmationByStaff;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getIdentifyNumber() {
		return identifyNumber;
	}
	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}
	public int getBirthOfYear() {
		return birthOfYear;
	}
	public void setBirthOfYear(int birthOfYear) {
		this.birthOfYear = birthOfYear;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
}
