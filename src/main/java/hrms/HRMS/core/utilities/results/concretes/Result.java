package hrms.HRMS.core.utilities.results.concretes;

import hrms.HRMS.core.utilities.results.abstracts.IResult;

public class Result implements IResult {
	 private boolean success;
	   private String message;
	   
	   public Result(boolean success) {
		   this.success = success;
	   }
	   
	   public Result(boolean success,String message) {
		   this(success);
		   this.message = message;
	   }
	   
	   public boolean isSuccess() {
		   return this.success;
	   }
	   
	   public String getMessage() {
		   return this.message;
	   }
}
