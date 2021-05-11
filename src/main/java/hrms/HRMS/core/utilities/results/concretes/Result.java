package hrms.HRMS.core.utilities.results.concretes;

public class Result {
	boolean success;
	String message;
	public Result(boolean success, String message) {
		this(success);
		this.success = success;
	}
	
	public Result(boolean success) {
		this.success = success;
	}
}
