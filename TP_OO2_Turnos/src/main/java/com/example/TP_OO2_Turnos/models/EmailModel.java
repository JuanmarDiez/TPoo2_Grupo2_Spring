package com.example.TP_OO2_Turnos.models;

import java.util.Arrays;

public class EmailModel {

    private String[] toUser;
    private String subject;
    private String message;
    
    public EmailModel() {}
    
	public EmailModel(String[] toUser, String subject, String message) {
		super();
		this.toUser = toUser;
		this.subject = subject;
		this.message = message;
	}
	
	public String[] getToUser() {
		return toUser;
	}
	public void setToUser(String[] toUser) {
		this.toUser = toUser;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "EmailModel [toUser=" + Arrays.toString(toUser) + ", subject=" + subject + ", message=" + message + "]";
	}
    
	
    
}
