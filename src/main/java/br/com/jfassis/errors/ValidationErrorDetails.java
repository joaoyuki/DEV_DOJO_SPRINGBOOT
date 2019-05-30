package br.com.jfassis.errors;

public class ValidationErrorDetails extends ErrorDetail {

	private String field;
	private String fieldMessage;
	
	
	
	public ValidationErrorDetails() {
	}

	public ValidationErrorDetails(String field, String fieldMessage) {
		this.field = field;
		this.fieldMessage = fieldMessage;
	}
	
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getFieldMessage() {
		return fieldMessage;
	}
	public void setFieldMessage(String fieldMessage) {
		this.fieldMessage = fieldMessage;
	}
	
	
	
}
