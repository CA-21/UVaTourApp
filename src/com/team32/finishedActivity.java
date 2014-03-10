package com.team32;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class finishedActivity extends Activity {
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finished);
        Button tryAgain = (Button) findViewById(R.id.tryagain);
        tryAgain.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				YourLocation yourLoc = new YourLocation();
				yourLoc.setTourLoc(1);
				Intent myIntent = new Intent(v.getContext(), Team32Activity.class);
		        startActivityForResult(myIntent, 0);			
			}
		});
    }

}
