package org.serviterobotics.friarbots;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AboutActivity extends BotsActivity {
	
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