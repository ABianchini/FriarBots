package org.serviterobotics.friarbots;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class ScoutingActivity extends BotsActivity {
	SharedPreferences scoutingData;
	//TODO pull (and parse) and push (and write) php data
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scout);
        scoutingData = getSharedPreferences(SCOUT_DATA, Context.MODE_PRIVATE);
        initOffDefSpinner();
        TextView offDefCheck = (TextView) findViewById(R.id.TextView_OffDefCheck);
        offDefCheck.setText(offDefHTML);
    }
    
    
    private void initOffDefSpinner() {
    	final Spinner spinner = (Spinner) findViewById(R.id.Spinner_Off_Def);
    	ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this,
				R.array.off_def, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setSelection(0);
		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent,View itemSelected, int selectedItemPosition, long selectedId) {
				if (selectedItemPosition == 0) offDefHTML = "Offense";
				if (selectedItemPosition == 1) offDefHTML = "Defense";
			}

			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
    }
    
}