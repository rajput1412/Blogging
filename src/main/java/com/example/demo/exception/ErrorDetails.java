package com.example.demo.exception;

import java.util.Date;

public class ErrorDetails {

	
	private Date timestamp;
	private String message;
	private String Details;
	/**
	 * @param timestamp
	 * @param message
	 * @param details
	 */
	
	public ErrorDetails(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.Details = details;
	}
}