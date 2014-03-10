package com.team32;

import com.team32.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;


public class Team32Activity2 extends Activity {

	//Objects for tour
	YourLocation yourLoc;
	Locations locs;
	TourLocation nextLoc;

	//Object for chronometer
	Chronometer chrono;

	//Objects for GPS
	private LocationManager locManager;
	private LocationListener locListener = new MyLocationListener();
	double prevLat;
	double prevLong;
	double currentDist;
	double prevDist;
	boolean hasReached = true;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.finddestination);
		chrono = (Chronometer)findViewById(R.id.chronometer1);
		chrono.start();
		yourLoc = new YourLocation();
		locs = new Locations();

		locs.loadData();

		nextLoc = locs.getNextLocation(yourLoc.getTourLoc());

		String myText = nextLoc.getName();
		TextView myTextView = (TextView) findViewById(R.id.getLocation);
		myTextView.setText(myText);

		String nextLocCord = "Location Coordinates: " + nextLoc.getLatitude() + "," + nextLoc.getLongitude();
		TextView myTextView2 = (TextView) findViewById(R.id.nextLocCord);
		myTextView2.setText(nextLocCord);



		//Creates button for settings
		Button settings = (Button) findViewById(R.id.settings);
		settings.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//yourLoc.setTourLoc(yourLoc.getTourLoc()+1);
				//Intent myIntent1 = new Intent(v.getContext(), LocationInfoActivity.class);
				Intent myIntent1 = new Intent(v.getContext(), DebugActivity.class);
				startActivityForResult(myIntent1, 0);			
			}
		});

		//Creates button for map
		Button map = (Button) findViewById(R.id.map);
		map.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent(v.getContext(), MyMapActivity.class);
				startActivityForResult(myIntent, 0);			
			}
		});

		locManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		if(DebugActivity.getMode()){
			
			yourLoc.setLatitude(DebugActivity.lat);
			yourLoc.setLongitude(DebugActivity.log);
			currentDist = yourLoc.distanceFromNextTarget(nextLoc);
			
			prevLat = yourLoc.getLatitude();
			prevLong = yourLoc.getLongitude();
			prevDist = currentDist;
			
			String userCord = "Your Coordinates: " + yourLoc.getLatitude() + "," + yourLoc.getLongitude();
			TextView myTextView3 = (TextView) findViewById(R.id.userLoc);
			myTextView3.setText(userCord);

		}
		else
			locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10, 0, locListener);
	}

	public class MyLocationListener implements LocationListener{

		@Override
		public void onLocationChanged(Location location) {
			ImageView hotterPic = (ImageView) findViewById(R.id.imageView1);
			ImageView colderPic = (ImageView) findViewById(R.id.imageView2);

				prevLat = yourLoc.getLatitude();
				prevLong = yourLoc.getLongitude();
				prevDist = currentDist;

				yourLoc.setLatitude(location.getLatitude());
				yourLoc.setLongitude(location.getLongitude());
				currentDist = yourLoc.distanceFromNextTarget(nextLoc);

			String userCord = "Your Coordinates: " + yourLoc.getLatitude() + "," + yourLoc.getLongitude();
			TextView myTextView3 = (TextView) findViewById(R.id.userLoc);
			myTextView3.setText(userCord);

			if(prevDist < currentDist) {
				hotterPic.setColorFilter(Color.BLACK);
				colderPic.clearColorFilter();
			}

			if(currentDist <= prevDist) {
				colderPic.setColorFilter(Color.BLACK);
				hotterPic.clearColorFilter();
			}

			if(currentDist <= .02 && hasReached) {
				yourLoc.setTourLoc(yourLoc.getTourLoc()+1);
				hasReached = false;
				Intent i = new Intent(getApplicationContext(), LocationInfoActivity.class);
				startActivity(i);
			}
			if(hasReached == false) {
				finish();
			}
		}

		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub

		}

	}

}
