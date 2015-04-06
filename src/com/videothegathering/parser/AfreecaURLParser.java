package com.videothegathering.parser;  
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class AfreecaURLParser {

	public String getAfreecaMovieURL(String url) {   //순차적으로 받아오는건데 가능?

		// url�κ��� vid �����ϱ�, string���� vid �����ؼ� ������ �����ϰ� "vid", "����"�� �Ѱ�
		String vid = null;
		
		Pattern pattern  =  Pattern.compile("(?<=..v.).*"); //http://175.158.11.15/vod/20150324/429/139081429_1.mp4?rand=0&start=120&end=180
		
		Matcher match = pattern.matcher(url);
		 
		if(match.find()){ 
		    vid = match.group(0); 
		}
		System.out.println(vid);
		
		Document doc;
		Elements elements = null;
		
		try {
			doc = Jsoup.connect("http://videofarm.daum.net/controller/api/open/v1_2/MovieLocation.apixml")
					  // vid 그대로
					  .data("vid", vid)	// 
					  .data("rand", "0")		// 
					  .data("start", "받아와야함")	// 
					  .data("end", "받아와야함")	// 

					  // and other hidden fields which are being passed in post request.
					  .userAgent("Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.118 Safari/537.36")	// 

					  .get();
			
			elements = doc.select("url");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	// post

		
		String result = null;
		
		for(Element e:elements){
			result = e.text();
			
		}
		
		return result;
	}
}