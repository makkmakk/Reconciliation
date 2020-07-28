package com.service;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.context.annotation.Configuration;

import com.model.PremiumDetail;

@Configuration
public class PremiumSearchService {
	
	
	private Set<PremiumDetail> premium=new HashSet<>();
	
	public Set<PremiumDetail> searchById(String id, TreeSet<PremiumDetail> set) {
		
		for (PremiumDetail pd : set) {
			if (id.equalsIgnoreCase(pd.getMemberId())) {
				premium.add(pd);
			}
		}
		return premium;
	}

	
	public Set<PremiumDetail> searchByName(String name, TreeSet<PremiumDetail> set) {
		for (PremiumDetail pd : set) {
			if (name.equalsIgnoreCase(pd.getMemberName())) {
				premium.add(pd);
			}
		}
		return premium;
	}
	
	public Set<PremiumDetail> searchByContactNumber(String contactNo, TreeSet<PremiumDetail> set) {
		for (PremiumDetail pd : set) {
			if (contactNo.equals(pd.getContactNumber())) {
				premium.add(pd);
			}
		}
		return premium;
	}
	
	
	
	public Set<PremiumDetail> findPremium(String str) {
		premium.clear();
		PremiumService premiumService=new PremiumService();
		if(str.matches("^[a-zA-Z]{1}[0-9]{4,10}")) {
			return searchById(str,premiumService.extractPremiumDetails());
		}else if(str.matches("^[a-zA-Z ]*")) {
			return searchByName(str,premiumService.extractPremiumDetails());
		}else if(str.matches("^[7-9]{1}[0-9]{9}")) {
			return searchByContactNumber(str,premiumService.extractPremiumDetails());
		}else {
			return premium;
		}
	}
	

}
