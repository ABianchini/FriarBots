package org.serviterobotics.friarbots;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

public class AboutActivity extends BotsActivity {
	
	//TODO Shared settings (for manual and automatic updates)
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        
        
    }
    
    public void onChangelogButtonClick(View view) {
    	startActivity(new Intent(AboutActivity.this, ChangeLogActivity.class));
    }
    
    
    
    
}