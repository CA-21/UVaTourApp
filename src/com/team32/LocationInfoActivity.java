package com.team32;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class LocationInfoActivity extends Activity {

	// Objects for tour
	YourLocation yourLoc;
	Locations locs;
	TourLocation thisLoc;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.locationinfo);

		yourLoc = new YourLocation();
		locs = new Locations();
		locs.loadData();
		thisLoc = locs.getNextLocation(yourLoc.getTourLoc() - 1);

		String myText = thisLoc.getName();
		TextView myTextView = (TextView) findViewById(R.id.currentLoc);
		myTextView.setText(myText);

		String locInfo = "Date Built: " + thisLoc.getDate() + "\n"
				+ thisLoc.getHistory();
		TextView myTextView2 = (TextView) findViewById(R.id.locInfo);
		myTextView2.setText(locInfo);

		if (yourLoc.getTourLoc()-1 == 1) {
			ImageView image = (ImageView) findViewById(R.id.locImage);
			image.setImageResource(R.drawable.rotunda);
		}

		if (yourLoc.getTourLoc()-1 == 2) {
			ImageView image = (ImageView) findViewById(R.id.locImage);
			image.setImageResource(R.drawable.two);
		}
		if (yourLoc.getTourLoc()-1 == 3) {
			ImageView image = (ImageView) findViewById(R.id.locImage);
			image.setImageResource(R.drawable.three);
		}
		if (yourLoc.getTourLoc()-1 == 4) {
			ImageView image = (ImageView) findViewById(R.id.locImage);
			image.setImageResource(R.drawable.four);
		}
		if (yourLoc.getTourLoc()-1 == 5) {
			ImageView image = (ImageView) findViewById(R.id.locImage);
			image.setImageResource(R.drawable.five);
		}
		if (yourLoc.getTourLoc()-1 == 6) {
			ImageView image = (ImageView) findViewById(R.id.locImage);
			image.setImageResource(R.drawable.six);
		}
		if (yourLoc.getTourLoc()-1 == 7) {
			ImageView image = (ImageView) findViewById(R.id.locImage);
			image.setImageResource(R.drawable.seven);
		}
		if (yourLoc.getTourLoc()-1 == 8) {
			ImageView image = (ImageView) findViewById(R.id.locImage);
			image.setImageResource(R.drawable.eight);
		}
		if (yourLoc.getTourLoc()-1 == 9) {
			ImageView image = (ImageView) findViewById(R.id.locImage);
			image.setImageResource(R.drawable.nine);
		}
		if (yourLoc.getTourLoc()-1 == 10) {
			ImageView image = (ImageView) findViewById(R.id.locImage);
			image.setImageResource(R.drawable.ten);
		}

		Button next = (Button) findViewById(R.id.toNextLocButton);
		next.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (yourLoc.getTourLoc() == 11) {
					Intent myIntent1 = new Intent(v.getContext(),
							finishedActivity.class);
					startActivityForResult(myIntent1, 0);
				} else {
					Intent myIntent = new Intent(v.getContext(),
							Team32Activity2.class);
					startActivityForResult(myIntent, 0);
				}
			}
		});
	}

}
