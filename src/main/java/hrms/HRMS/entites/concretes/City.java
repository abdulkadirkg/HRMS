package hrms.HRMS.entites.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "cities")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","city"})
public class City {
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}

	public City(int id, String cityName, int plateNumber) {
		super();
		this.id = id;
		this.cityName = cityName;
		this.plateNumber = plateNumber;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	@Column(name = "city_name")
	String cityName;
	@Column(name = "plate_number")
	int plateNumber;

	@OneToMany(mappedBy = "city")
	List<JobAdvertisement> jobAdvertisement;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(int plateNumber) {
		this.plateNumber = plateNumber;
	}
}
