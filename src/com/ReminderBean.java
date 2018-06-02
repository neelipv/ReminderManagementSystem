package com;

public class ReminderBean {

	private int id;
	private String event;
	private String date;
	
	public ReminderBean(String event, String date) {
		super();
		this.event = event;
		this.date = date;
	}
	
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
