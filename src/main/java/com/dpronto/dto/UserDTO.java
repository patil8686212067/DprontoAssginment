package com.dpronto.dto;

public class UserDTO {
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getSrNo() {
		return srNo;
	}
	@Override
	public String toString() {
		return "SrNumber:"+srNo+ "[firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
	private String firstName;
	private String lastName;
	private int srNo;

}
