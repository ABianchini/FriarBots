package org.serviterobotics.friarbots;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public class BotsActivity extends Activity {
	public static final String SCOUT_DATA = "scoutData";
	
	public static final String MANUAL_UPDATES = "manUp";
	public static final String SCOUT_DATA_OFF_DEF = "off_def";
	
	public String teamNumberJSON;
	public String offDefJSON;
	public String crossMethodJSON;
	public String otherNotesJSON;
	public String numBalanceJSON;
	public String balanceRankJSON;
	
	public void popIt(int title, int msg){
        new AlertDialog.Builder(this)
        .setTitle(title)
        .setMessage(msg)
        .setNegativeButton("Close", new OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {}
        }).show();
    }
	
}

