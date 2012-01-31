package org.serviterobotics.friarbots;

import android.os.Bundle;

public class ScoutingActivity extends BotsActivity {
	//TODO pull (and parse) and push (and write) xml data
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scout);
    }
    
}