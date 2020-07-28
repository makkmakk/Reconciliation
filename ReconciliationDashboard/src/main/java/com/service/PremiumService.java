package com.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.TreeSet;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import com.model.PremiumDetail;

@Configuration
public class PremiumService {

	private static String uploadfile = "E://temp//empty.txt";
	PremiumValidateService service = new PremiumValidateService();

	public int addPremiumDetails(MultipartFile file) {
		try {
			int a=0;
			File temp = new File(uploadfile);
			if (temp.createNewFile());
			String str=new String(file.getBytes()).replaceAll("[\r\n]+","\r\n").replaceAll("[ ]+"," ").replaceAll("[\\W&&[^ \r\n]]",",")
					.replaceAll("[,]+",",");
			System.out.println(str);
			String[] split=str.split("\\R+");
			for(String s:split) {
				String[] arr=service.validateString(s.split("[^\\w ]"));
				System.out.println(arr[0]+arr[1]+arr[2]);
				if(arr!=null && arr.length>0){
					if(!(arr[0].equals("N/A")&&arr[1].equals("N/A")&&arr[3].equals("N/A"))) {
						if (temp.length() != 0) {
							Files.write(Paths.get(uploadfile), System.lineSeparator().getBytes(), StandardOpenOption.APPEND);
						}
						Files.write(Paths.get(uploadfile), 
								(arr[0]+","+arr[1]+","+arr[2]+","+arr[3]+","+arr[4]+","+arr[5]+","+arr[6]+","+arr[7]).getBytes(), 
								StandardOpenOption.APPEND);
						a++;
					}
				}
			}
			return a;
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public TreeSet<PremiumDetail> extractPremiumDetails() {

		FileReader fr;
		Comparator<PremiumDetail> compareById = (PremiumDetail o1, PremiumDetail o2) -> o1.getMemberId()
				.compareTo(o2.getMemberId());
		TreeSet<PremiumDetail> set = new TreeSet<>(compareById);
		
		try {
			fr = new FileReader(uploadfile);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				String str[] =service.validateString(line.split("[^\\w ]"));
				PremiumDetail premiumdetail = new PremiumDetail(
						str[0], str[1],str[2],str[3],str[4],str[5],str[6],str[7]);
				set.add(premiumdetail);
			}
			br.close();
			fr.close();
		
			return set;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public PremiumDetail searchById(String id, TreeSet<PremiumDetail> set) {
		PremiumDetail premium=new PremiumDetail();
		for (PremiumDetail pd : set) {
			if (id.equalsIgnoreCase(pd.getMemberId())) {
				premium = pd;
			}
		}
		return premium;
	}

}
