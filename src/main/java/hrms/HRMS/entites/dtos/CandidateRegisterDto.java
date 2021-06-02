package hrms.HRMS.entites.dtos;

import java.util.Date;

public class CandidateRegisterDto {
	public CandidateRegisterDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CandidateRegisterDto(String name, String surname, String identifyNumber, Date birthDate, String eMail,
			String password, String passwordRepeat) {
		super();
		this.name = name;
		this.surname = surname;
		this.identifyNumber = identifyNumber;
		this.birthDate = birthDate;
		this.eMail = eMail;
		this.password = password;
		this.passwordRepeat = passwordRepeat;
	}
	String name;
	String surname;
	String identifyNumber;
	Date birthDate;
	String eMail;
	String password;
	String passwordRepeat;
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
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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
	public String getPasswordRepeat() {
		return passwordRepeat;
	}
	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
	}
}
