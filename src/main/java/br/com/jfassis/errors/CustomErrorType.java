package br.com.jfassis.errors;

public class CustomErrorType {
	
	private String errorMessage;

	public CustomErrorType(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
