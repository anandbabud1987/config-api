package com.rbc.test.constants;

public enum ExceptionMessage {
	
	UNABLE_TO_GET("Unable to fetch document details");
	
	private String exceptionMessage;

	ExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String exceptionMessage() {
        return exceptionMessage;
    }

}
