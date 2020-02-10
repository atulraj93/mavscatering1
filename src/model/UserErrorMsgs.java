package model;

public class UserErrorMsgs {
	
	private String usernameError;
	private String passwordError;
	private String roleError;
	private String utaIdError;
	private String firstNameError;
	private String lastNameError;
	private String phoneError;
	private String emailError;
	private String streetNumberError;
	private String streetNameError;
	private String cityError;
	private String stateError;
	private String zipcodeError;
	private String errorMsgs;
	
	public UserErrorMsgs() {
		this.usernameError = "";
		this.passwordError = "";
		this.roleError = "";
		this.utaIdError = "";
		this.firstNameError = "";
		this.lastNameError = "";
		this.phoneError = "";
		this.emailError = "";
		this.streetNumberError = "";
		this.streetNameError = "";
		this.cityError = "";
		this.stateError = "";
		this.zipcodeError = "";
		this.errorMsgs = "";
	}
	
	public String getUsernameError() {
		return usernameError;
	}
	public void setUsernameError(String usernameError) {
		this.usernameError = usernameError;
	}
	public String getPasswordError() {
		return passwordError;
	}
	public void setPasswordError(String passwordError) {
		this.passwordError = passwordError;
	}
	public String getRoleError() {
		return roleError;
	}
	public void setRoleError(String roleError) {
		this.roleError = roleError;
	}
	public String getUtaIdError() {
		return utaIdError;
	}
	public void setUtaIdError(String utaIdError) {
		this.utaIdError = utaIdError;
	}
	public String getFirstNameError() {
		return firstNameError;
	}
	public void setFirstNameError(String firstNameError) {
		this.firstNameError = firstNameError;
	}
	public String getLastNameError() {
		return lastNameError;
	}
	public void setLastNameError(String lastNameError) {
		this.lastNameError = lastNameError;
	}
	public String getPhoneError() {
		return phoneError;
	}
	public void setPhoneError(String phoneError) {
		this.phoneError = phoneError;
	}
	public String getEmailError() {
		return emailError;
	}
	public void setEmailError(String emailError) {
		this.emailError = emailError;
	}
	public String getStreetNumberError() {
		return streetNumberError;
	}
	public void setStreetNumberError(String streetNumberError) {
		this.streetNumberError = streetNumberError;
	}
	public String getStreetNameError() {
		return streetNameError;
	}
	public void setStreetNameError(String streetNameError) {
		this.streetNameError = streetNameError;
	}
	public String getCityError() {
		return cityError;
	}
	public void setCityError(String cityError) {
		this.cityError = cityError;
	}
	public String getStateError() {
		return stateError;
	}
	public void setStateError(String stateError) {
		this.stateError = stateError;
	}
	public String getZipcodeError() {
		return zipcodeError;
	}
	public void setZipcodeError(String zipcodeError) {
		this.zipcodeError = zipcodeError;
	}
	public String getErrorMsgs() {
		return errorMsgs;
	}
	public void setErrorMsgs() {
		if (!usernameError.equals("") || !passwordError.equals("") || !utaIdError.equals("") || !firstNameError.equals("") || !lastNameError.equals("")
				|| !phoneError.equals("") || !emailError.equals("") || !streetNumberError.equals("") || !streetNameError.equals("") || !cityError.equals("")
				|| !stateError.equals("") || !zipcodeError.equals("") || !roleError.equals(""))
			this.errorMsgs = "Please correct the following errors";
	}

	
}
