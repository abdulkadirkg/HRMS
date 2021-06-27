package hrms.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.HRMS.business.abstracts.ResumeService;
import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.core.utilities.results.concretes.SuccessDataResult;
import hrms.HRMS.core.utilities.results.concretes.SuccessResult;
import hrms.HRMS.dataAccess.abstracts.ResumeDao;
import hrms.HRMS.entites.concretes.Resume;

@Service
public class ResumeManager implements ResumeService {
	@Autowired
	ResumeDao resumeDao;

	@Override
	public IResult add(Resume resume) {
		resumeDao.save(resume);
		return new SuccessResult("Özgeçmiş Başarıyla Eklendi");
	}

	@Override
	public IResult update(Resume resume) {
		Resume resumeToUpdate = resumeDao.getById(resume.getId());
		resumeToUpdate.setResumeText(resume.getResumeText());
		resumeToUpdate.setIsActive(resume.getIsActive());
		resumeToUpdate.setCandidate(resume.getCandidate());
		resumeDao.save(resumeToUpdate);
		return new SuccessResult("Özgeçmiş Başarıyla Güncellendi");
	}

	@Override
	public IResult delete(Resume resume) {
		resumeDao.delete(resume);
		return new SuccessResult("Özgeçmiş Başarıyla Silindi");
	}

	@Override
	public IDataResult<List<Resume>> getByResumeText(String resumeText) {
		return new SuccessDataResult<List<Resume>>(resumeDao.getByResumeText(resumeText));
	}

	@Override
	public IDataResult<List<Resume>> getByResumeTextContains(String resumeText) {
		return new SuccessDataResult<List<Resume>>(resumeDao.getByResumeTextContains(resumeText));

	}

	@Override
	public IDataResult<List<Resume>> getByResumeTextStartsWith(String resumeText) {
		return new SuccessDataResult<List<Resume>>(resumeDao.getByResumeTextStartsWith(resumeText));

	}

	@Override
	public IDataResult<List<Resume>> getByResumeTextEndsWith(String resumeText) {
		return new SuccessDataResult<List<Resume>>(resumeDao.getByResumeTextEndsWith(resumeText));

	}

	@Override
	public IDataResult<List<Resume>> getByCandidate_Id(int candidateId) {
		return new SuccessDataResult<List<Resume>>(resumeDao.getByCandidate_Id(candidateId));

	}

	@Override
	public IDataResult<List<Resume>> getAll() {
		return new SuccessDataResult<List<Resume>>(resumeDao.findAll());

	}

	@Override
	public IDataResult<Resume> getById(int id) {
		return new SuccessDataResult<Resume>(resumeDao.getById(id));

	}

}
