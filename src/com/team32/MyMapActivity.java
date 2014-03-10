package com.team32;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import android.os.Bundle;

public class MyMapActivity extends MapActivity {

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        MapView mapView = (MapView) findViewById(R.id.map);
        mapView.setBuiltInZoomControls(true);
    }
 
    @Override
    protected boolean isRouteDisplayed() {
        return false;
    }

}
