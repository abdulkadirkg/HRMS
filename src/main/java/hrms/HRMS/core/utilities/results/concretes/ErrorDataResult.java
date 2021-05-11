package hrms.HRMS.core.utilities.results.concretes;

public class ErrorDataResult<T> extends DataResult<T> {
	public ErrorDataResult(T data, String message) {
		super(data, false, message);
	}

	public ErrorDataResult(T data) {
		super(data, true);
	}

	public ErrorDataResult(String message) {
		super(null, false, message);
	}

	public ErrorDataResult() {
		super(null, false);
	}
}
