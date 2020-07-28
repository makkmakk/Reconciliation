package com.model;

public class PremiumDetail {
	
	private String memberId;
	private String memberName;
	private String memberType;
	private String claimNumber;
	private String checkNum;
	private String contactNumber;
	private String age;
	private String email;
	
	
	public PremiumDetail() {
	
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	public String getMemberType() {
		return memberType;
	}


	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}


	public String getClaimNumber() {
		return claimNumber;
	}


	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}


	public String getCheckNum() {
		return checkNum;
	}


	public void setCheckNum(String checkNum) {
		this.checkNum = checkNum;
	}


	public String getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public PremiumDetail(String memberId, String memberName, String memberType, String claimNumber, String checkNum,
			String contactNumber, String age, String email) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberType = memberType;
		this.claimNumber = claimNumber;
		this.checkNum = checkNum;
		this.contactNumber = contactNumber;
		this.age = age;
		this.email = email;
	}


	@Override
	public String toString() {
		return "PremiumDetail [memberId=" + memberId + ", memberName=" + memberName + ", memberType=" + memberType
				+ ", claimNumber=" + claimNumber + ", checkNum=" + checkNum + ", contactNumber=" + contactNumber
				+ ", age=" + age + ", email=" + email + "]";
	}


}
