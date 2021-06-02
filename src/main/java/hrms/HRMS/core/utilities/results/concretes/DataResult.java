package hrms.HRMS.core.utilities.results.concretes;

import hrms.HRMS.core.utilities.results.abstracts.IDataResult;

public class DataResult<T> extends Result implements IDataResult<T> {
	private T data;

	public DataResult(T data, boolean success, String message) {
		super(success, message);
		this.data = data;
	}

	public DataResult(T data, boolean success) {
		super(success);
		this.data = data;
	}

	public T getData() {
		return this.data;
	}
}
