package hrms.HRMS.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import hrms.HRMS.core.utilities.results.abstracts.IDataResult;
import hrms.HRMS.core.utilities.results.abstracts.IResult;
import hrms.HRMS.entites.concretes.Candidate;
import hrms.HRMS.entites.dtos.CandidateRegisterDto;
import hrms.HRMS.entites.dtos.DetailedCandidateDto;

public interface CandidateService {
	IResult add(Candidate candidate);
	IResult update(Candidate candidate);
	IResult delete(Candidate candidate);
	IDataResult<Candidate> get(int Id);
	IDataResult<DetailedCandidateDto> getDetailedCandidate(int Id);
	IDataResult<List<Candidate>> getAll();
	IResult register(CandidateRegisterDto candidateRegisterDto);
	IResult uploadImage(int candidateId, MultipartFile image);
}
