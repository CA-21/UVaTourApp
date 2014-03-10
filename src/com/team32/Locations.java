package com.team32;

import java.util.ArrayList;

public class Locations {

	ArrayList<TourLocation> locations = new ArrayList<TourLocation>();
	
	String name;
	double latitude;
	double longitude;
	String date;
	String history;
	String picture;
	int order;
	
	public void loadData() {
		name = "Rotunda";
		latitude = 38.035472;
		longitude = -78.503489;
		date = "1826";
		history = "Designed by Thomas Jefferson. Original Rotunda burnt down in the Great Rotunda Fire of 1895. Restored to Jefferson's original design in 1977";
		picture = "1.jpg";
		order = 1;
		locations.add(new TourLocation(latitude, longitude, name, picture, history, date, order));
		
		name = "Chapel";
		latitude = 38.036289;
		longitude = -78.504457;
		date = "1890";
		history = "UVa was one the first Universities in the US to be designed around a library rather than a Chapel. In fact Jefferson had no plans for there to be religious studies at all. Eventually this nondenominational chapel was constructed";
		picture = "2.jpg";
		order = 2;
		locations.add(new TourLocation(latitude, longitude, name, picture, history, date, order));

		name = "Alderman Library";
		latitude = 38.036346;
		longitude = -78.505407;
		date = "1938";
		history = "Named after the first President of UVa Alderman Library was originally designed to hold 600000 volumes. It now holds over 2 million items";
		picture = "3.jpg";
		order = 3;
		locations.add(new TourLocation(latitude, longitude, name, picture, history, date, order));

		name = "Edgar Allan Poe's Room";
		latitude = 38.03555;
		longitude = -78.504964;
		date = "1826";
		history = "This room was occupied by Edgar Allan Poe during his 10 month stint at UVa.";
		picture = "4.jpg";
		order = 4;
		locations.add(new TourLocation(latitude, longitude, name, picture, history, date, order));

		name = "Homer Statue";
		latitude = 38.033253;
		longitude = -78.504677;
		date = "1907";
		history = "Sclupted by Moses Ezekiel depicts Greek writer Homer";
		picture = "5.jpg";
		order = 5;
		locations.add(new TourLocation(latitude, longitude, name, picture, history, date, order));

		name = "Amphitheater";
		latitude = 38.033596;
		longitude = -78.505766;
		date = "1921";
		history = "Designed by the head of UVa School of Architecture used for student gatherings and musical events";
		picture = "6.jpg";
		order = 6;
		locations.add(new TourLocation(latitude, longitude, name, picture, history, date, order));

		name = "Darden Court";
		latitude = 38.032966;
		longitude = -78.509881;
		date = "1925";
		history = "Center of the UVa School of Engineering and Applied Scineces";
		picture = "7.jpg";
		order = 7;
		locations.add(new TourLocation(latitude, longitude, name, picture, history, date, order));

		name = "Rice Hall";
		latitude = 38.031593;
		longitude = -78.510742;
		date = "2011";
		history = "Newest academic building at UVa and home of the Department of Computer Science";
		picture = "8.jpg";
		order = 8;
		locations.add(new TourLocation(latitude, longitude, name, picture, history, date, order));

		name = "Scott Stadium";
		latitude = 38.032193;
		longitude = -78.514679;
		date = "1930";
		history = "Home of Wahoo Football! Originally built to hold 25000 fans the stadium now can hold 64947 fans, GO HOOS, BEAT TECH!(please)";
		picture = "9.jpg";
		order = 9;
		locations.add(new TourLocation(latitude, longitude, name, picture, history, date, order));

		name = "Ohill Dining Room";
		latitude = 38.034719;
		longitude = -78.514808;
		date = "2004";
		history = "Newest dining hall on grounds, you totally don't mind eating the food, because, hey, atleast it's food!";
		picture = "10.jpg";
		order = 10;
		locations.add(new TourLocation(latitude, longitude, name, picture, history, date, order));
	}
	
	public TourLocation getNextLocation(int ord) {
		for(TourLocation loc : locations) {
			if(loc.getOrder() == ord) {
				return loc;
			}
		}
		return null;
	}
	
	public ArrayList<TourLocation> getLocations() {
		return locations;
	}
}
