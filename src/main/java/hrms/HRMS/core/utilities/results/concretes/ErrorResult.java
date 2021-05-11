package hrms.HRMS.core.utilities.results.concretes;

public class ErrorResult extends Result{
	public ErrorResult(String message) {
		super(false, message);
	}

	public ErrorResult() {
		super(false);
	}
}
