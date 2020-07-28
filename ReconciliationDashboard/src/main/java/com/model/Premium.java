package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Premium {
	
	@Id
	private String premiumId;
	private String memberName;
	private long contactNo;
	
	public String getPremiumId() {
		return premiumId;
	}
	public void setPremiumId(String premiumId) {
		this.premiumId = premiumId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public long getContactNo() {
		return contactNo;
	}
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	@Override
	public String toString() {
		return "Premium [premiumId=" + premiumId + ", memberName=" + memberName + ", contactNo=" + contactNo + "]";
	}
}
