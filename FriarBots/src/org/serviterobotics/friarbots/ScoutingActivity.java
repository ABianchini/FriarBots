package org.serviterobotics.friarbots;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
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
        initCrossMethodSpinner();
        initTeamNumEdit();
        initOtherNotesEdit();
        initHowManyBalanceSpinner();
        initBalanceRanking();
        
    }
    
    /*private void onUploadButtonClick(View view) {
    	writeJSON();
    }*/
    
    private void initBalanceRanking() {
    	final RatingBar ratingbar = (RatingBar) findViewById(R.id.RatingBar_Balance);
    	ratingbar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
    	    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
    	        balanceRankJSON = String.valueOf(rating);
    	    }
    	});
    }
    
    private void writeJSON() {
    	JSONObject object = new JSONObject();
    	try {
    		object.put("Team Number", new String(teamNumberJSON));
    	} catch (JSONException e) {
    		e.printStackTrace();
    	}
    	//TextView scoutTest = (TextView) findViewById(R.id.TextView_ScoutTest);
    	//scoutTest.setText(object);
    	Log.d("test","Maybe this JSON worked"+object);
    	//System.out.println(object);
    }
    
    private void initTeamNumEdit() {
    	EditText teamNumber = (EditText) findViewById(R.id.EditText_TeamNumber);
    	teamNumber.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            	EditText teamNumber = (EditText) findViewById(R.id.EditText_TeamNumber);
                teamNumberJSON = teamNumber.getText().toString();
            }
            // ... other required overrides need not be implemented 
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
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
				if (selectedItemPosition == 0) offDefJSON = "Offense";
				if (selectedItemPosition == 1) offDefJSON = "Defense";
			}

			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
    }
    
    private void initCrossMethodSpinner() {
    	final Spinner spinner = (Spinner) findViewById(R.id.Spinner_CrossMethod);
    	ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this,
				R.array.cross_method, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setSelection(0);
		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent,View itemSelected, int selectedItemPosition, long selectedId) {
				if (selectedItemPosition == 0) crossMethodJSON = "Bumper";
				if (selectedItemPosition == 1) crossMethodJSON = "Bridge";
				if (selectedItemPosition == 2) crossMethodJSON = "Both";
				if (selectedItemPosition == 3) crossMethodJSON = "Neither";
			}

			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
    }
    
    private void initHowManyBalanceSpinner() {
    	final Spinner spinner = (Spinner) findViewById(R.id.Spinner_HowManyBalance);
    	ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this,
				R.array.number_balance, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setSelection(0);
		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent,View itemSelected, int selectedItemPosition, long selectedId) {
				if (selectedItemPosition == 0) numBalanceJSON = "0";
				if (selectedItemPosition == 1) numBalanceJSON = "1";
				if (selectedItemPosition == 2) numBalanceJSON = "2";
				if (selectedItemPosition == 3) numBalanceJSON = "We cant balance";
			}

			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
    }
    
    private void initOtherNotesEdit() {
    	EditText otherNotes = (EditText) findViewById(R.id.EditText_OtherNotes);
    	otherNotes.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            	EditText otherNotes = (EditText) findViewById(R.id.EditText_OtherNotes);
                otherNotesJSON = otherNotes.getText().toString();
            }
            // ... other required overrides need not be implemented 
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
    }
    
}