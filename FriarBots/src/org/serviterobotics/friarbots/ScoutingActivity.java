package org.serviterobotics.friarbots;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.Spinner;
import android.widget.Toast;

public class ScoutingActivity extends BotsActivity {
	SharedPreferences scoutingData;
	
	
	//TODO pull and parse JSON
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
        initBalanceOrderSpinner();
        initPlayedWith();
        initOppBalanceExist();
        
    }
    
    public void onUploadButtonClick(View view) {
    	writeJSON();
    	Toast.makeText(this, "Not Uploaded", Toast.LENGTH_SHORT).show();
    }
    
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
    		object.put("teamNumber", teamNumberJSON);
    		object.put("ROE", offDefJSON);
    		object.put("crossMethod", crossMethodJSON);
    		object.put("numRobotsBalanceWith", numBalanceJSON);
    		object.put("balanceRank", balanceRankJSON);
    		object.put("otherNotes", otherNotesJSON);
    		object.put("balanceOrder", balanceOrderJSON);
    		object.put("numPlayedWith", numPlayedWithJSON);
    		object.put("oppBalanceExist", oppBalanceExistJSON);
    	} catch (JSONException e) {
    		e.printStackTrace();
    	}
    	System.out.println(object);
        HttpPost post = new HttpPost("http://3309scouting.appspot.com/frcscoutingupload");
    	try {
    		post.setHeader("Content-type", "application/json");
    		post.setHeader("Accept", "application/json");
			post.setEntity(new StringEntity(object.toString(), "UTF-8"));
			new DefaultHttpClient().execute(post);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
    
    private void initPlayedWith() {
    	final Spinner spinner = (Spinner) findViewById(R.id.Spinner_PlayedWith);
    	ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this,
				R.array.num_played_with, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setSelection(0);
		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent,View itemSelected, int selectedItemPosition, long selectedId) {
				if (selectedItemPosition == 0) numPlayedWithJSON = "0";
				if (selectedItemPosition == 1) numPlayedWithJSON = "1";
				if (selectedItemPosition == 2) numPlayedWithJSON = "2";
				if (selectedItemPosition == 3) numPlayedWithJSON = "3";
				if (selectedItemPosition == 4) numPlayedWithJSON = "4";
				if (selectedItemPosition == 5) numPlayedWithJSON = "5";
				if (selectedItemPosition == 6) numPlayedWithJSON = "6";
			}

			public void onNothingSelected(AdapterView<?> parent) {
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
    
    private void initBalanceOrderSpinner() {
    	final Spinner spinner = (Spinner) findViewById(R.id.Spinner_BalanceOrder);
    	ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this,
				R.array.balance_order, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setSelection(0);
		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent,View itemSelected, int selectedItemPosition, long selectedId) {
				if (selectedItemPosition == 0) balanceOrderJSON = "First";
				if (selectedItemPosition == 1) balanceOrderJSON = "Second";
				if (selectedItemPosition == 2) balanceOrderJSON = "Third";
				if (selectedItemPosition == 3) balanceOrderJSON = "We cant balance";
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
    
    private void initOppBalanceExist() {
    	final Spinner spinner = (Spinner) findViewById(R.id.Spinner_OppBalanceExist);
    	ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this,
				R.array.yes_no, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setSelection(0);
		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent,View itemSelected, int selectedItemPosition, long selectedId) {
				if (selectedItemPosition == 0) oppBalanceExistJSON = "Yes";
				if (selectedItemPosition == 1) oppBalanceExistJSON = "No";
			}

			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
    }
    
}