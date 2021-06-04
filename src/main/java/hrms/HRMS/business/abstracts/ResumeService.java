package hrms.HRMS.business.abstracts;

import java.util.List;

import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.entites.concretes.Resume;

public interface ResumeService {
	IResult add(Resume resume);

	IResult update(Resume resume);

	IResult delete(Resume resume);

	IDataResult<List<Resume>> getByResumeText(String resumeText);

	IDataResult<List<Resume>> getByResumeTextContains(String resumeText);

	IDataResult<List<Resume>> getByResumeTextStartsWith(String resumeText);

	IDataResult<List<Resume>> getByResumeTextEndsWith(String resumeText);

	IDataResult<List<Resume>> getByCandidate_Id(int candidateId);

	IDataResult<List<Resume>> getAll();

	IDataResult<Resume> getById(int id);
}
