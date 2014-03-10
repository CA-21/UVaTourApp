package com.team32;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends Activity {
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
		//locManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        Button next = (Button) findViewById(R.id.beginTour);
        next.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent(v.getContext(), Team32Activity2.class);
		        startActivityForResult(myIntent, 0);			
			}
		});
    }

}
