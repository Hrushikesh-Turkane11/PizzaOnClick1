package com.app.pojos;

public enum Status  {

	ORDER_RECEIVED(1),PAYEMNT_RECEIVED(2),DELIVERED(3),PENDING(4);
	
	private int statusId;
	
	private Status(int statusId) {
		this.statusId=statusId;
	}

	public int getStatusId() {
		return statusId;
	}
	
	
	
	
}
