package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.service.PremiumSearchService;
import com.service.PremiumService;

@Controller
public class PremiumController {

	@Autowired
	private PremiumService service;
	@Autowired
	private PremiumSearchService search;

	@RequestMapping(value = "/fileUpload", method = RequestMethod.GET)
	public String fileUpload(ModelMap map) {
		map.addAttribute("premiumlist", service.extractPremiumDetails());
		return "premiumDetails";
	}

	@RequestMapping(value = "/premiumDetails", method = RequestMethod.POST)
	public String premiumDetails(@RequestParam(value = "file", required = false) MultipartFile file, ModelMap map,RedirectAttributes ra) {
		int a=service.addPremiumDetails(file);
			if (a>0) {
				ra.addFlashAttribute("success", "You Successfully Uploaded '" + file.getOriginalFilename()
						 +"'. Details extracted from your file and added in the library are ["+a+"]");
			}else {
				ra.addFlashAttribute("failure", "Upload a file contains Valid PremiumDetails");
			}
		return "redirect:/fileUpload";
	}
	
	@RequestMapping(value = "/getPremiumSearchDetails", method = RequestMethod.GET)
	public String getPremiumSearchDetails() {
		return "premiumDetails";
	}

	@RequestMapping(value = "/postPremiumSearchDetails", method = RequestMethod.POST)
	public String premiumSearchDetails(ModelMap map, @RequestParam(value = "search", required = false) String str,RedirectAttributes ra) {
		if (str == null) {
			map.addAttribute("premiumlist", service.extractPremiumDetails());
		} else {
			ra.addFlashAttribute("premiumlist", search.findPremium(str));
		}
		return "redirect:/getPremiumSearchDetails";
	}

}
