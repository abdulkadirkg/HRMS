package hrms.HRMS.entites.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "candidates")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "schools", "resumes", "jobExperiences", "languages",
		"programmingLanguages" })
public class Candidate {

	public Candidate(int id, String name, String surname, String identifyNumber, Date birth, String eMail,
			String password, String profilePicture, String githubAddress, String linkedinAddress, Date createdAt,
			Date updatedAt, Date deletedAt, List<School> schools, ConfirmationByMail confirmationByMail,
			ConfirmationByStaff confirmationByStaff) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.identifyNumber = identifyNumber;
		this.birth = birth;
		this.eMail = eMail;
		this.password = password;
		this.profilePicture = profilePicture;
		this.githubAddress = githubAddress;
		this.linkedinAddress = linkedinAddress;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
		this.schools = schools;
		this.confirmationByMail = confirmationByMail;
		this.confirmationByStaff = confirmationByStaff;
	}

	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
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
	Date birth;
	@Column(name = "e_mail")
	String eMail;
	@Column(name = "password")
	String password;
	@Column(name = "profile_picture")
	String profilePicture;
	@Column(name = "github_address",columnDefinition="TEXT")
	String githubAddress;
	@Column(name = "linkedin_address",columnDefinition="TEXT")
	String linkedinAddress;
	@Column(name = "created_at")
	Date createdAt = new Date();
	@Column(name = "updated_at")
	Date updatedAt = new Date();
	@Column(name = "deleted_at")
	Date deletedAt = new Date();

	@OneToMany(mappedBy = "candidate")
	List<School> schools;

	@OneToMany(mappedBy = "candidate")
	List<Resume> resumes;

	@OneToMany(mappedBy = "candidate")
	List<JobExperience> jobExperiences;

	@OneToMany(mappedBy = "candidate")
	List<Language> languages;

	@OneToMany(mappedBy = "candidate")
	List<ProgrammingLanguage> programmingLanguages;

	@OneToOne()
	@JoinColumn(name = "mail_confirmation_id", referencedColumnName = "id")
	ConfirmationByMail confirmationByMail;
	
	@OneToOne()
	@JoinColumn(name = "staff_confirmation_id", referencedColumnName = "id")
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

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
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

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getGithubAddress() {
		return githubAddress;
	}

	public void setGithubAddress(String githubAddress) {
		this.githubAddress = githubAddress;
	}

	public String getLinkedinAddress() {
		return linkedinAddress;
	}

	public void setLinkedinAddress(String linkedinAddress) {
		this.linkedinAddress = linkedinAddress;
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

	public List<School> getSchools() {
		return schools;
	}

	public void setSchools(List<School> schools) {
		this.schools = schools;
	}

	public List<Resume> getResumes() {
		return resumes;
	}

	public void setResumes(List<Resume> resumes) {
		this.resumes = resumes;
	}

	public List<JobExperience> getJobExperiences() {
		return jobExperiences;
	}

	public void setJobExperiences(List<JobExperience> jobExperiences) {
		this.jobExperiences = jobExperiences;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public List<ProgrammingLanguage> getProgrammingLanguages() {
		return programmingLanguages;
	}

	public void setProgrammingLanguages(List<ProgrammingLanguage> programmingLanguages) {
		this.programmingLanguages = programmingLanguages;
	}
}
