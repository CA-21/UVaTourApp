package com.team32;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.view.View;


public class DebugActivity extends Activity{

	static boolean mode = false;
	static double lat = 0;
	static double log = 0;
	YourLocation yourLoc;



	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.debug);
		CheckBox debug = (CheckBox) findViewById(R.id.checkBox1);
		yourLoc = new YourLocation();
		debug.setOnCheckedChangeListener(new OnCheckedChangeListener(){


			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if(isChecked){
					mode=true;
					EditText Lat = (EditText) findViewById(R.id.editText1);
					EditText Long = (EditText) findViewById(R.id.editText2);
					lat = Double.parseDouble(Lat.getText().toString());
					log = Double.parseDouble(Long.getText().toString());

					Intent it2 = new Intent(getBaseContext(), Team32Activity2.class);
					onPause();
					startActivity(it2);
				}
				else
					mode=false;
			}

		});
		
		Button settings = (Button) findViewById(R.id.AdvanceLocation);
		settings.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				yourLoc.setTourLoc(yourLoc.getTourLoc()+1);
				Intent myIntent1 = new Intent(v.getContext(), LocationInfoActivity.class);
				startActivityForResult(myIntent1,0);
			}
		});




	}
	public static boolean getMode(){
		return mode;
	}

}
