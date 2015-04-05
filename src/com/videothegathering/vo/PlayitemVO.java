package com.videothegathering.vo;

import java.util.Date;

public class PlayitemVO {

	// 사용할 변수 선언

	private int id;

	private String URL;

	private String Title;

	private String realMP4;
	
	private Date date;

	// Value Object 선언

	public PlayitemVO() {
	}

	// 테이블 요소 

	public PlayitemVO(int id, String URL, String Title, String realMP4, Date date) {

		// id, url, 제목, 가능한가 여부, 날짜

		this.id = id;

		this.URL = URL;

		this.Title = Title;

		this.realMP4 = realMP4;

		this.date = date;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getRealMP4() {
		return realMP4;
	}

	public void setRealMP4(String realMP4) {
		this.realMP4 = realMP4;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
