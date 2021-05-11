package hrms.HRMS.core.utilities.results.concretes;

public class SuccessResult extends Result {
	public SuccessResult(String message) {
		super(true, message);
	}

	public SuccessResult() {
		super(true);
	}
}
