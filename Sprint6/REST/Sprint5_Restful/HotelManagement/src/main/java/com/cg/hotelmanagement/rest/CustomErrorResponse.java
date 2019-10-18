/**
 * 
 */
package com.cg.hotelmanagement.rest;

/**
 * @author Saurabh
 * Description: To display a custom response in case of exception.
 * Attributes:
 *   Status: To display status code
 *   message: To display custom error message
 *   timestamp: To display timestamp
 *
 */
public class CustomErrorResponse {
	
	private int status;
	private String message;
	private long timestamp;
	
	public CustomErrorResponse(int status, String message, long timestamp) {
		super();
		this.status = status;
		this.message = message;
		this.timestamp = timestamp;
	}

	public CustomErrorResponse() {
		super();
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}
