package com.service;

public class PremiumValidateService {

	public String[] validateString(String[] premium) {

		String[] validated = { "N/A", "N/A", "N/A", "N/A", "NoCheck", "Nil", "N/A", "N/A" };

		for (int i = 0; i < premium.length; i++) {
			if (premium[i].matches("^[a-zA-Z]{1}[0-9]{4,10}")) {
				if (validated[0].equals("N/A")) {
					validated[0] = premium[i];
				} else if (validated[0].equalsIgnoreCase(premium[i])) {
					continue;
				} else {
					return null;
				}
			} else if (premium[i].matches("^[a-zA-Z ]*")&&(!(premium[i].equalsIgnoreCase("gold")
					|| premium[i].equalsIgnoreCase("silver")||premium[i].equalsIgnoreCase("diamond")))) {
				if (validated[1].equals("N/A")) {
					validated[1] = premium[i];
				} else if (validated[1].equalsIgnoreCase(premium[i])) {
					continue;
				}
			} else if ((premium[i].equalsIgnoreCase("gold"))||(premium[i].equalsIgnoreCase("silver"))
					||(premium[i].equalsIgnoreCase("diamond"))) {
				if (validated[2].equals("N/A")) {
					validated[2] = premium[i];
				} else if (validated[2].equalsIgnoreCase(premium[i])) {
					continue;
				}
			} else if (premium[i].matches("^[1-9]{1}[0-9]{13}")) {
				if (validated[3].equals("N/A")) {
					validated[3] = premium[i];
				} else if (validated[3].equalsIgnoreCase(premium[i])) {
					continue;
				}
			} else if (premium[i].matches("^[1-9]{1}[0-9]{7}")) {
				if (validated[4].equals("NoCheck")) {
					validated[4] = premium[i];
				} else if (validated[4].equalsIgnoreCase(premium[i])) {
					continue;
				}
			} else if (premium[i].matches("^[6-9]{1}[0-9]{9}")) {
				if (validated[5].equals("Nil")) {
					validated[5] = premium[i];
				} else if (validated[5].equalsIgnoreCase(premium[i])) {
					continue;
				}
			} else if (premium[i].matches("^[2-6]{1}[0-9]{1}")) {
				if (validated[6].equals("N/A")) {
					validated[6] = premium[i];
				} else if (validated[6].equalsIgnoreCase(premium[i])) {
					continue;
				}
			} else if (premium[i].matches("^[a-zA-Z0-9]{1,}[@]{1}[a-z]{1,}[.]{1}[a-z]{1,}")) {
				if (validated[7].equals("N/A")) {
					validated[7] = premium[i];
				} else if (validated[7].equalsIgnoreCase(premium[i])) {
					continue;
				}
			}
		}
		return validated;
	}


}
