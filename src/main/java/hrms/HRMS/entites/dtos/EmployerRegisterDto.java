package hrms.HRMS.entites.dtos;

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
	String companyName;
	String webSite;
	String eMail;
	String phone;
	String password;
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
