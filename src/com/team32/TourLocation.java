package com.team32;

public class TourLocation {
	
	double latitude;
	double longitude;
	String name;
	String picture;
	String history;
	String date;
	int order;
	
	public TourLocation(double lat, double lon, String nam, 
			String pic, String his, String dat, int ord ) {
		latitude = lat;
		longitude = lon;
		name = nam;
		picture = pic;
		history = his;
		date = dat;
		order = ord;
	}

	public TourLocation() {
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDate() {
		return date;
	}

	
}
