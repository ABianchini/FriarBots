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
    	SharedPreferences manUpPref = getSharedPreferences(MANUAL_UPDATES, MODE_PRIVATE);
        SharedPreferences.Editor editor = manUpPref.edit();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        
        final CheckBox checkbox = (CheckBox) findViewById(R.id.Checkbox_ManUpdate);
        checkbox.setOnClickListener(new OnClickListener() {
        	SharedPreferences manUpPref = getSharedPreferences(MANUAL_UPDATES, MODE_PRIVATE);
        	SharedPreferences.Editor editor = manUpPref.edit();
            public void onClick(View v) {
                // Perform action on clicks, depending on whether it's now checked
                if (((CheckBox) v).isChecked()) {
                    editor.putBoolean(MANUAL_UPDATES, true);
                } else {
                    editor.putBoolean(MANUAL_UPDATES, false);
                }
                editor.commit();
            }
        });
    }
    
    public void onChangelogButtonClick(View view) {
    	startActivity(new Intent(AboutActivity.this, ChangeLogActivity.class));
    }
    
    public void onUpdateHelpClick(View view) {
    	popIt(R.string.checkbox_update, R.string.update_help);
    }
    
    
    
}