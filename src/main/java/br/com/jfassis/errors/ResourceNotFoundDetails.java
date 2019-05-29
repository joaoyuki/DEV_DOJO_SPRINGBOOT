package br.com.jfassis.errors;

public class ResourceNotFoundDetails {

	private String title;
	private int status;
	private String detail;
	private Long timestamp;
	private String developerMessage;
	
	public ResourceNotFoundDetails(String title, int status, String detail, Long timestamp, String developerMessage) {
		this.title = title;
		this.status = status;
		this.detail = detail;
		this.timestamp = timestamp;
		this.developerMessage = developerMessage;
	}

	public ResourceNotFoundDetails() {
	}

	public String getTitle() {
		return title;
	}

	public int getStatus() {
		return status;
	}

	public String getDetail() {
		return detail;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}
	
	
	
}
