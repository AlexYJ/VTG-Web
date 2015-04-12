package com.videothegathering.parser;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VimeoURLParser_2 {

	public String getVimeoMovieURL_2(String url) {

		String num = null;

		Pattern pat = Pattern
				.compile("(?<=https:.pdlvimeocdn-a.akamaihd.net.).*");

		Matcher mat = pat.matcher(url);

		if (mat.find()) {
			num = mat.group(0);
		}
		System.out.println(num);

		Document doc = null;
		Elements elements = null;
		String Tag = null;

		String s2 = "받아와야함";
		String p2 = "[/]";
		String[] sArray2 = s2.split(p2);

		for (int i = 0; i < sArray2.length; i++) {
			System.out.println(sArray2[i]);
		}
		try {

			Connection conn = Jsoup
					.connect("https://pdlvimeocdn-a.akamaihd.net/" + sArray2)
					.data("token2", "0")
					.data("aksessionid", "1")
					.data("ns", "4")
					// request.
					.referrer("http://vimeo.com/" + num)
					.ignoreContentType(true)
					.userAgent(
							"Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.118 Safari/537.36")
					.timeout(5000); //
			Connection.Response resp = conn.execute();
			if (resp.statusCode() == 200) {
				doc = conn.get();
				elements = doc.select("body");

				String result = null;

				for (Element e : elements) {
					result = e.html();
				}

				System.out.println(result);
				Pattern pattern = Pattern
						.compile("(?<=\"sd\").*?(?=\",\"height\":)");
				// ������ ����.

				Matcher match = pattern.matcher(result);

				if (match.find()) {
					Tag = match.group(0);
				}

				pattern = Pattern.compile("http://.*");
				match = pattern.matcher(Tag);

				if (match.find()) {
					Tag = match.group(0);
				}
				System.out.println(Tag);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // post ��û

		return Tag;
	}
}
