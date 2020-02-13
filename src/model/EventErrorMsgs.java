package model;

public class EventErrorMsgs {

	private String errorMsg;
	private String duplicateResMsg;
	private String invalidCCNum;
	private String invalidCVVNum;
	private String invalidExpDate;
	private String timeerror;
	private String capacityError;
	private String staffError;
	
	public EventErrorMsgs () {
		this.errorMsg="";
		this.duplicateResMsg="";
		this.invalidCCNum="";
		this.invalidCVVNum="";
		this.invalidExpDate = "";
		this.timeerror = "";
		this.setCapacityError("");
		this.setStaffError("");
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg() {
		if (!duplicateResMsg.equals("")
				||!invalidCCNum.equals("")
				||!invalidCVVNum.equals("")
				||!invalidExpDate.equals("")
				||!timeerror.equals("")
				||!staffError.equals(""))
		  errorMsg="Please correct the following errors";
	}
	
	public String getduplicateResMsg() {
		return duplicateResMsg;
	}

	public void setduplicateResMsg(String duplicateResMsg) {
		this.duplicateResMsg = duplicateResMsg;
	}

	public String getinvalidCCNum() {
		return invalidCCNum;
	}

	public void setinvalidCCNum(String invalidCCNum) {
		this.invalidCCNum = invalidCCNum;
	}
	
	public String getinvalidCVVNum() {
		return invalidCCNum;
	}

	public void setinvalidCVVNum(String invalidCVVNum) {
		this.invalidCVVNum = invalidCVVNum;
	}
	
	public String getinvalidExpDate() {
		return invalidCCNum;
	}

	public void setinvalidExpDate(String invalidExpDate) {
		this.invalidExpDate = invalidExpDate;
	}
	
	public String gettimeerror() {
		return invalidCCNum;
	}

	public void settimeerror(String timeerror) {
		this.timeerror = timeerror;
	}

	public String getCapacityError() {
		return capacityError;
	}

	public void setCapacityError(String capacityError) {
		this.capacityError = capacityError;
	}

	public String getStaffError() {
		return staffError;
	}

	public void setStaffError(String staffError) {
		this.staffError = staffError;
	}
	


}