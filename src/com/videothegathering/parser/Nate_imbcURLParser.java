package com.videothegathering.parser;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Nate_imbcURLParser {

	public String getNate_imbcURL(String url) {

		String vid = null;
		
		Pattern pattern  =  Pattern.compile("(?<=http://vodmall.imbc.com/player/player./natePlayer.html?.v.).*");
		
		Matcher match = pattern.matcher(url);
		 
		if(match.find()){ 
		    vid = match.group(0); 
		}
		System.out.println(vid);
		
		Document doc;
		Elements elements = null;
		
		try {
			doc = Jsoup.connect("http://vodmall.imbc.com/player/player./natePlayer.html")
					  // ��û �� �ʿ��� parameter �� 
					  .data("itemid", "받아오기")	// 
					  .data("isAutoPlay", "N")		// 
					  .data("broID", "받아오기")	// 

					  // and other hidden fields which are being passed in post request.
					  .userAgent("Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.118 Safari/537.36")	// 

					  .get();
			
			elements = doc.select("url");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	// post ��û 

		
		String result = null;
		
		for(Element e:elements){
			result = e.text();
			
		}
		
		return result;
	}
}