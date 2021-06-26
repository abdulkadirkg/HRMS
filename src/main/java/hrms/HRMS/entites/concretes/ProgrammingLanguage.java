package hrms.HRMS.entites.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
@Entity
@Table(name = "programming_languages")
public class ProgrammingLanguage {
	public ProgrammingLanguage() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	@NotBlank
	@NotNull
	@Column(name = "programming_language_name")
	String programmingLanguageName;
	
	@ManyToOne
	@JoinColumn(name = "candidate_id")
//	@JsonIgnore
	Candidate candidate;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProgrammingLanguageName() {
		return programmingLanguageName;
	}

	public void setProgrammingLanguageName(String programmingLanguageName) {
		this.programmingLanguageName = programmingLanguageName;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Column(name = "level")
	int level;

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
}
