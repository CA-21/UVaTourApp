package com.team32;

public class YourLocation {

	double latitude;
	double longitude;
	static int tourLoc = 1;

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

	public int getTourLoc() {
		return tourLoc;
	}

	public void setTourLoc(int tourLoc) {
		YourLocation.tourLoc = tourLoc;
	}

	public double distanceFromNextTarget(TourLocation loc) {
		double toRadians = Math.PI / 180;
		double rad2deg = 180 / Math.PI;

		double locLat = toRadians * loc.getLatitude();
		double locLon = loc.getLongitude();

		double theta = locLon - longitude;
		double dist = Math.sin(locLat) * Math.sin(toRadians * latitude)
				+ Math.cos(locLat) * Math.cos(toRadians * latitude)
				* Math.cos(toRadians * theta);
		dist = Math.acos(dist);
		dist = dist * rad2deg;
		dist = dist * 60 * 1.1515;
		dist = dist * 1.609344;

		return dist;
	}
}
