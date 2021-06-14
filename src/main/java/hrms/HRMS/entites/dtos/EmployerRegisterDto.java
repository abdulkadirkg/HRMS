package hrms.HRMS.entites.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


import com.sun.istack.NotNull;

public class EmployerRegisterDto {
	public EmployerRegisterDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployerRegisterDto(String companyName, String webSite, String eMail, String phone, String password,
			String passwordRepeat) {
		super();
		this.companyName = companyName;
		this.webSite = webSite;
		this.eMail = eMail;
		this.phone = phone;
		this.password = password;
		this.passwordRepeat = passwordRepeat;
	}
	@NotNull
	@NotBlank(message = "Şirket Adı Alanı Boş Olamaz")
	@Size(min = 2, max = 35)
	String companyName;
	String webSite;
	@NotNull
	@NotBlank(message = "E-Mail Alanı Boş Olamaz")
	@Size(min = 2, max = 35)
	@Email
	String eMail;
	@NotNull
	@NotBlank(message = "Telefon Alanı Boş Olamaz")
	@Size(min = 10, max = 13)
	String phone;
	@NotNull
	@NotBlank(message = "Şifre Alanı Boş Olamaz")
	@Size(min = 10, max = 13)
	String password;
	@NotNull
	@NotBlank
	@Size(min = 10, max = 13)
	String passwordRepeat;
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
	public String getPasswordRepeat() {
		return passwordRepeat;
	}
	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
	}
}
