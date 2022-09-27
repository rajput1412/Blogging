package com.example.demo.exception;

public class ResourceNotFoundException extends Exception {
	
	

		private static final long serialVersionUID = 1L;

		public ResourceNotFoundException(String message) {
			
			super(message);
		}

	
//	 String resourceName;
//	 String fieldName;
//	 long fieldvalue;
//	public ResourceNotFoundException(String resourceName, String fieldName, long fieldvalue) {
//		super();
//		//super(String.format("%s not found with %s:%l ", resourceName,fieldName,fieldvalue));
//		this.resourceName = resourceName;
//		this.fieldName = fieldName;
//		this.fieldvalue = fieldvalue;
//	}
	 

}
